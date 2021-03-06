package pl.redblue.warszawa.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;
import pl.redblue.warszawa.add.AddActivity;
import pl.redblue.warszawa.bar.BarActivity;
import pl.redblue.warszawa.bar.SingleBarActivity;
import pl.redblue.warszawa.communication.CommunicationActivity;
import pl.redblue.warszawa.party.PartyMainActivity;
import pl.redblue.warszawa.places.FireBaseActivity;
import pl.redblue.warszawa.restaurant.AdapterRestaurant;
import pl.redblue.warszawa.restaurant.RestaurantActivity;

public class MainActivity extends AppCompatActivity implements MainMVP.View, MenuRecyclerViewAdapter.ItemClickListener {

    private static final String TAG = "permissionMsg";
    private static final int RECORD_REQUEST_CODE = 101;
    private MainMVP.Presenter presenter;
    @BindView(R.id.recyclerMain)
    RecyclerView recyclerView;
    MenuRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to external storage denied");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    RECORD_REQUEST_CODE);
        }

        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        presenter.createMenuList();


    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(MainActivity.this, CommunicationActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MainActivity.this, FireBaseActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MainActivity.this, BarActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MainActivity.this, PartyMainActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }



    @Override
    public void setMenu(List<MainMenuModel> list) {
        adapter = new MenuRecyclerViewAdapter(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}
