package pl.redblue.warszawa.places;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlacePresenter implements PlacesMVP.Presenter {

    private PlacesMVP.View viewMVP;
    private DatabaseReference reference;
    private List<Place> list;
    ValueEventListener value;

    PlacePresenter(PlacesMVP.View viewMVP){
        this.viewMVP = viewMVP;
        reference = FirebaseDatabase.getInstance().getReference().child("places");
        list = new ArrayList<>();
    }

    @Override
    public void loadData() {
        ValueEventListener value = new ValueEventListener(){
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    list.clear();

                    for(DataSnapshot s : dataSnapshot.getChildren()){
                        Place place = s.getValue(Place.class);
                        list.add(place);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
        reference.addValueEventListener(value);
        viewMVP.addAdapter(list);
        }


    public List<Place> getList() {
        return list;
    }
}
