package pl.redblue.warszawa.add.addparty;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;
import pl.redblue.warszawa.party.Party;

public class AddPartyActivity extends AppCompatActivity {

    private StorageReference mStorageRef;
    private Uri filePath;
    private Party party;
    @BindView(R.id.editAddPartyName)
    EditText partyName;
    @BindView(R.id.editAddPartyAddress)
    EditText partyAddress;
    @BindView(R.id.editAddPartyDay)
    EditText partyDay;
    @BindView(R.id.editAddPartyMonth)
    EditText partyMonth;
    @BindView(R.id.editAddPartyYear)
    EditText partyYear;
    @BindView(R.id.editAddPartyHours)
    EditText partyHours;
    @BindView(R.id.editAddPartyMinutes)
    EditText partyMinutes;
    @BindView(R.id.editAddPartyPrice)
    EditText partyPrice;
    @BindView(R.id.editAddPartyDescription)
    EditText partyDescription;
    @BindView(R.id.buttonAddPartyAccept)
    Button buttonPartyAccept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_party);
        ButterKnife.bind(this);
        party = new Party();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        buttonPartyAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                party.setNameParty(partyName.getText().toString());
                party.setAdressParty(partyAddress.getText().toString());
                String myOwnDate = partyDay.getText().toString()+"."+
                        partyMonth.getText().toString()+"."+
                        partyYear.getText().toString()+" , "+
                        partyHours.getText().toString()+":"+
                        partyMinutes.getText().toString();
                party.setDateParty(myOwnDate);
                party.setPrizeParty(partyPrice.getText().toString());
            }
        });
    }

    public void addImageParty(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode!=RESULT_CANCELED){
            if(requestCode==1){
                filePath =  data.getData();
                StorageReference imgRef = mStorageRef.child("images/"+ UUID.randomUUID().toString());
                imgRef.putFile(filePath)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                party.setPhotoParty(downloadUrl.toString());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            }
                        });
            }
        }
    }

}
