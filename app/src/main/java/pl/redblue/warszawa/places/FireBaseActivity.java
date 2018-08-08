package pl.redblue.warszawa.places;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;
import pl.redblue.warszawa.communication.CommunicationActivity;
import pl.redblue.warszawa.main.MainActivity;

public class FireBaseActivity extends AppCompatActivity implements PlacesMVP.View, PlaceRecyclerAdapter.ItemClickListener {

    RecyclerView recyclerView;
    private List<Place> list;
    private DatabaseReference reference;
    ValueEventListener value;
    PlaceRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);
        reference = FirebaseDatabase.getInstance().getReference().child("places");
        reference.keepSynced(true);
        list = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerPlaces);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new PlaceRecyclerAdapter(this,list);
        adapter.setClickListener(this);

    }



    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list.clear();

                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Place place = s.getValue(Place.class);
                    list.add(place);
                }

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void addAdapter(List<Place> places) {

    }


    @Override
    public void onItemClick(View view, int position) {
                Intent i = new Intent(FireBaseActivity.this, SingleFullPlace.class);
                i.putExtra("PlaceObject", list.get(position));
                startActivity(i);
    }
}
