package pl.redblue.warszawa.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pl.redblue.warszawa.R;
import pl.redblue.warszawa.add.addbar.AddBarActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addAttraction(View view) {

    }

    public void addRestaurant(View view) {
        Intent i = new Intent(AddActivity.this, AddBarActivity.class);
        startActivity(i);
    }

    public void addBar(View view) {
    }

    public void addParty(View view) {
    }
}
