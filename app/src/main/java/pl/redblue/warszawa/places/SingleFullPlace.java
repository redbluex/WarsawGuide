package pl.redblue.warszawa.places;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;

public class SingleFullPlace extends AppCompatActivity {

    @BindView(R.id.textName)
    TextView namePlace;
    @BindView(R.id.textAdress)
    TextView adressPlace;
    @BindView(R.id.imagePlacePhoto)
    ImageView imagePlacePhoto;
    @BindView(R.id.textOpen)
    TextView openPlace;
    @BindView(R.id.buttonNavigate)
    Button buttonNavigate;

    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_full_place);
        ButterKnife.bind(this);
        Intent i = getIntent();
        place = (Place)i.getSerializableExtra("PlaceObject");
        namePlace.setText(place.getName());
        adressPlace.setText(place.getAdress());
        openPlace.setText(place.getOpen());
        Picasso.get().load(place.getPhotoLink()).into(imagePlacePhoto);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse(place.getUriPlace());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });
    }
}
