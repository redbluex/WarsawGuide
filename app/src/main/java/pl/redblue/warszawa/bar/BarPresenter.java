package pl.redblue.warszawa.bar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BarPresenter implements BarMVP.Presenter {
    private BarMVP.View view;
    private List<Bar> bars;
    private DatabaseReference databaseReference;

    public BarPresenter(BarMVP.View view){
        this.view = view;
        bars = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("bar");
    }

    public List<Bar> getBars() {
        return bars;
    }

    @Override
    public void loadFireBaseDate() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bars.clear();

                for(DataSnapshot s : dataSnapshot.getChildren()){
                    Bar bar = s.getValue(Bar.class);
                    bars.add(bar);
                }
                view.addAdapter();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
