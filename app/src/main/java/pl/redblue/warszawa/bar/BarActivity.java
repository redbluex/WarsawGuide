package pl.redblue.warszawa.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class BarActivity extends AppCompatActivity implements RecyclerAdapterBar.ItemClick, BarMVP.View {

    private RecyclerView recyclerView;
    private RecyclerAdapterBar recyclerAdapterBar;
    private BarMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        presenter = new BarPresenter(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerBar);
        recyclerAdapterBar = new RecyclerAdapterBar(presenter.getBars(), this);
        recyclerAdapterBar.setItemClick(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadFireBaseDate();
    }

    @Override
    public void onItemClick(View view, int position) {
        Bar bar = presenter.getBars().get(position);
        Intent i = new Intent(BarActivity.this, SingleBarActivity.class);
        i.putExtra("barObject", bar);
        startActivity(i);
    }

    @Override
    public void addAdapter() {
        recyclerView.setAdapter(recyclerAdapterBar);
    }
}
