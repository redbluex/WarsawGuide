package pl.redblue.warszawa.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pl.redblue.warszawa.R;
import pl.redblue.warszawa.add.addbar.AddBarActivity;
import pl.redblue.warszawa.add.addparty.AddPartyActivity;
import pl.redblue.warszawa.add.addrestaurant.AddRestaurantActivity;
import pl.redblue.warszawa.add.places.AddPlacesActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addAttraction(View view) {
        Intent i = new Intent(AddActivity.this, AddPlacesActivity.class);
        startActivity(i);
    }

    public void addRestaurant(View view) {
        Intent i = new Intent(AddActivity.this, AddRestaurantActivity.class);
        startActivity(i);
    }

    public void addBar(View view) {
        Intent i = new Intent(AddActivity.this, AddBarActivity.class);
        startActivity(i);
    }

    public void addParty(View view) {
        Intent i = new Intent(AddActivity.this, AddPartyActivity.class);
        startActivity(i);
    }
}
