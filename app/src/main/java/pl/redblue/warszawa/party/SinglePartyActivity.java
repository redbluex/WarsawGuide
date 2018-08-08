package pl.redblue.warszawa.party;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;

public class SinglePartyActivity extends AppCompatActivity {
    @BindView(R.id.textsNamePart)
    TextView nameParty;
    @BindView(R.id.textsDatePart)
    TextView dateParty;
    @BindView(R.id.textsAdressParty)
    TextView adressParty;
    @BindView(R.id.textsDescriptionParty)
    TextView descriptionParty;
    @BindView(R.id.textsPrizeParty)
    TextView prizeParty;
    @BindView(R.id.imagesPatyPhoto)
    ImageView imageParty;
    private Party singleParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_party);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        singleParty = (Party)intent.getSerializableExtra("partyObject");
        nameParty.setText(singleParty.getNameParty());
        dateParty.setText(singleParty.getDateParty());
        adressParty.setText(singleParty.getAdressParty());
        descriptionParty.setText(singleParty.getDescriptionParty());
        prizeParty.setText(singleParty.getPrizeParty());
        Picasso.get().load(singleParty.getPhotoParty()).resize(600,200).into(imageParty);


    }
}
