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

public class PartyMainActivity extends AppCompatActivity implements RecyclerAdapterParty.ItemClickListener {

    RecyclerView recyclerView;
    RecyclerAdapterParty recyclerAdapterParty;
    List<Party>list;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_main);
        list = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference().child("party");


        recyclerView = (RecyclerView)findViewById(R.id.recyclerParty);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapterParty = new RecyclerAdapterParty(this, list);
        recyclerAdapterParty.setClickListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
       Intent intent = new Intent(PartyMainActivity.this, SinglePartyActivity.class);
       intent.putExtra("partyObject", list.get(position));
       startActivity(intent);
}

    @Override
    protected void onStart() {
        super.onStart();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot d : dataSnapshot.getChildren()){
                    Party party = d.getValue(Party.class);
                    list.add(party);
                }
                recyclerView.setAdapter(recyclerAdapterParty);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        list.clear();
    }
}
