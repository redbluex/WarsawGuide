package pl.redblue.warszawa.bar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;

public class SingleBarActivity extends AppCompatActivity {
    @BindView(R.id.textBarName)
    TextView barName;
    @BindView(R.id.textBarAdress)
    TextView barAdress;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar;
    @BindView(R.id.imageThumbUp)
    ImageView thumbUp;
    @BindView(R.id.imageThumbDown)
    ImageView thumbDown;

    private Bar bar;
    private DatabaseReference databaseReference;
    private boolean clickedUp, clickedDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bar);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        bar = (Bar) intent.getSerializableExtra("barObject");
        barName.setText(bar.getNameBar());
        barAdress.setText(bar.getAdressBar());
        setProgressBar();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("bar").child(bar.getIdBar());
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bar = dataSnapshot.getValue(Bar.class);
                setProgressBar();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        clickedUp = sharedPref.getBoolean("clickUp",false);
        clickedDown = sharedPref.getBoolean("clickDown", false);
        setThumbs();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("clickUp", clickedUp);
        editor.putBoolean("clickDown", clickedDown);
        editor.commit();
    }

    public void setProgressBar(){
        double thumbsUp = bar.getThumbsUp();
        double thumbsDown = bar.getThumbsDown();
        double thumbsSum = thumbsUp+thumbsDown;
        double thumbsRatio = (thumbsUp/thumbsSum)*100;
        progressBar.setProgress((int)thumbsRatio);
    }

    public void setThumbs(){
        if(clickedUp==true){
            thumbUp.setImageResource(R.drawable.baseline_thumb_up_black_24dp);
        }
        if(clickedDown==true){
            thumbDown.setImageResource(R.drawable.baseline_thumb_down_black_24dp);
        }
        if(clickedUp==false){
            thumbUp.setImageResource(R.drawable.outline_thumb_up_black_24dp);
        }
        if(clickedDown==false){
            thumbDown.setImageResource(R.drawable.outline_thumb_down_black_24dp);
        }
    }


    public void thumbsUpClick(View view) {
        if(clickedUp==false && clickedDown==false) {
            databaseReference.child("thumbsUp").setValue(bar.getThumbsUp() + 1);
            clickedUp=true;
        }
        else if(clickedUp==true && clickedDown==false){
            databaseReference.child("thumbsUp").setValue(bar.getThumbsUp() - 1);
            clickedUp=false;
        }
        else if(clickedUp==false && clickedDown==true){
            databaseReference.child("thumbsUp").setValue(bar.getThumbsUp() + 1);
            databaseReference.child("thumbsDown").setValue(bar.getThumbsDown() - 1);
            clickedUp=true;
            clickedDown=false;
        }
        setThumbs();

    }

    public void thumbsDownClick(View view) {
        if(clickedDown==false && clickedUp==false) {
            databaseReference.child("thumbsDown").setValue(bar.getThumbsDown() + 1);
            clickedDown = true;
        }
        else if(clickedDown==true && clickedUp==false){
            databaseReference.child("thumbsDown").setValue(bar.getThumbsDown() - 1);
            clickedDown = false;
        }
        else if(clickedDown==false && clickedUp==true){
            databaseReference.child("thumbsDown").setValue(bar.getThumbsDown() + 1);
            databaseReference.child("thumbsUp").setValue(bar.getThumbsUp() - 1);
            clickedDown=true;
            clickedUp=false;
        }
        setThumbs();
    }
}
