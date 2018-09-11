package pl.redblue.warszawa.add.places;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;
import pl.redblue.warszawa.main.MainActivity;
import pl.redblue.warszawa.places.Place;

public class AddPlacesActivity extends AppCompatActivity {

    @BindView(R.id.editAddPlaceName)
    EditText placeName;
    @BindView(R.id.editAddPlaceAddress)
    EditText placeAddress;
    @BindView(R.id.buttonAddPlacePhoto)
    Button buttonAddPhoto;
    @BindView(R.id.buttonAddPlaceAccept)
    Button buttonPlaceAccept;
    @BindView(R.id.imageViewAddPlace)
    ImageView imageViewAddPlace;

    Place place;
    private final int REQUEST_PHOTO_PLACE = 88;
    private Uri filePath;
    private Bitmap bitmap;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private StorageReference storageReferencePlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_places);
        ButterKnife.bind(this);
        place = new Place();
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("places");
        storageReferencePlace = storageReference.child("place/"+ UUID.randomUUID().toString());


        buttonAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPhoto();
            }
        });

        buttonPlaceAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Wait a second!", Toast.LENGTH_SHORT).show();

                storageReferencePlace.putFile(filePath)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                place.setPhotoLink(taskSnapshot.getDownloadUrl().toString());
                               setFileds();
                               databaseReference.child(place.getIdPlace()).setValue(place);
                               Intent intent = new Intent(AddPlacesActivity.this, MainActivity.class);
                               startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Cant add new Place!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddPlacesActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });

    }

    public void selectPhoto(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 88);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_PHOTO_PLACE && requestCode!=RESULT_CANCELED){
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                imageViewAddPlace.setImageBitmap(bitmap);
                imageViewAddPlace.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFileds(){
        String id = databaseReference.push().getKey();
        place.setIdPlace(id);
        place.setName(placeName.getText().toString());
        place.setAdress(placeAddress.getText().toString());
        place.setUriPlace("geo:0,0?q="+place.getAdress());
    }



    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radioButtonYes:
                if(checked) {
                    place.setOpen("YES");
                }
                break;
            case R.id.radioButtonNo:
                if(checked) {
                    place.setOpen("NO");
                }
                break;
        }
    }
}
