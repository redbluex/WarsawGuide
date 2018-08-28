package pl.redblue.warszawa.add.addbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pl.redblue.warszawa.bar.Bar;

public class AddBarPresenter implements AddBarMVP.Presenter {

    private AddBarMVP.View view;
    private DatabaseReference databaseReference;

    public AddBarPresenter(AddBarMVP.View view){
        this.view = view;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("bar");
    }

    @Override
    public void addFireBaseElement(Bar bar) {
        String id = databaseReference.push().getKey();
        bar.setIdBar(id);
        bar.setThumbsDown(0);
        bar.setThumbsUp(0);
        databaseReference.child(id).setValue(bar);
        view.addElement();
    }
}
