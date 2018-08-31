package pl.redblue.warszawa.add.addrestaurant;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;
import pl.redblue.warszawa.main.MainActivity;
import pl.redblue.warszawa.restaurant.Restaurant;

public class AddRestaurantActivity extends AppCompatActivity {

    @BindView(R.id.editRestaurantName)
    EditText restaurantName;
    @BindView(R.id.buttonAddRestaurantPhoto)
    Button restaurantPhoto;
    @BindView(R.id.buttonAddRestaurantAccept)
    Button restaurantAccept;

    private Restaurant restaurant;
    private Uri filePath;
    private StorageReference storageReference;
    private Uri urlFireBasePhoto;
    private DatabaseReference databaseReference;
    private StorageReference sRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        ButterKnife.bind(this);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("restaurants");
        sRef = storageReference.child("party/"+ UUID.randomUUID().toString());
        restaurant = new Restaurant();

        restaurantPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPhotoUri();
            }
        });

        restaurantAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sRef.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        urlFireBasePhoto = taskSnapshot.getDownloadUrl();
                        restaurant.setPhotoRestaurant(urlFireBasePhoto.toString());
                        setAllFields();
                        databaseReference.child(restaurant.getIdRestaurant()).setValue(restaurant);
                        Intent intent = new Intent(AddRestaurantActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
            }
        });

    }

    public void getPhotoUri(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    public void setAllFields(){
        restaurant.setNameRestaurant(restaurantName.getText().toString());
        restaurant.setLikeRatio(0);
        String idRestaurant = databaseReference.push().getKey();
        restaurant.setIdRestaurant(idRestaurant);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK && requestCode==1){
            filePath = data.getData();
        }
    }
}
