package pl.redblue.warszawa.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class RestaurantActivity extends AppCompatActivity {
    private AdapterRestaurant adapter;
    private RecyclerView recyclerView;
    private List<Restaurant> restaurants;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        restaurants = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("restaurants");
        recyclerView = (RecyclerView)findViewById(R.id.restaurantRecycler);
        adapter = new AdapterRestaurant(this, restaurants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                restaurants.clear();

                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Restaurant restaurant = s.getValue(Restaurant.class);
                    restaurants.add(restaurant);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
