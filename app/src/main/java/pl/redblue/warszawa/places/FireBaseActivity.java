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
    ValueEventListener value;
    PlaceRecyclerAdapter adapter;
    PlacePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);
        presenter = new PlacePresenter(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerPlaces);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void addAdapter(List<Place> places) {
        adapter = new PlaceRecyclerAdapter(this,places);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
                Intent i = new Intent(FireBaseActivity.this, SingleFullPlace.class);
                i.putExtra("PlaceObject", presenter.getList().get(position));
                startActivity(i);
    }
}
