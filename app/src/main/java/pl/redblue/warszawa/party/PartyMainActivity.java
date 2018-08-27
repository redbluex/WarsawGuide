package pl.redblue.warszawa.party;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class PartyMainActivity extends AppCompatActivity implements RecyclerAdapterParty.ItemClickListener, PartyMVP.View {

    RecyclerView recyclerView;
    RecyclerAdapterParty recyclerAdapterParty;
    private PartyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_main);
        presenter = new PartyPresenter(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerParty);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapterParty = new RecyclerAdapterParty(this, presenter.getParties());
        recyclerAdapterParty.setClickListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
       Intent intent = new Intent(PartyMainActivity.this, SinglePartyActivity.class);
       intent.putExtra("partyObject", presenter.getParties().get(position));
       startActivity(intent);
}

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadFireBaseDate();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void setAdapterList() {
        recyclerView.setAdapter(recyclerAdapterParty);
    }
}
