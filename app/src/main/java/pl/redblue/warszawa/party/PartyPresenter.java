package pl.redblue.warszawa.party;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PartyPresenter implements PartyMVP.Presenter {
    private List<Party> parties;
    private PartyMVP.View view;
    private DatabaseReference ref;

    public PartyPresenter(PartyMVP.View view){
        this.view = view;
        parties = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference().child("party");
    }

    @Override
    public List<Party> getParties() {
        return parties;
    }

    @Override
    public void loadFireBaseDate() {
        parties.clear();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot d : dataSnapshot.getChildren()){
                    Party party = d.getValue(Party.class);
                    parties.add(party);
                }
                view.setAdapterList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
