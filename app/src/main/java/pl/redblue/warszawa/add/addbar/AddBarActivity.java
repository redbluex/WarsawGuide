package pl.redblue.warszawa.add.addbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;
import pl.redblue.warszawa.bar.Bar;
import pl.redblue.warszawa.main.MainActivity;

public class AddBarActivity extends AppCompatActivity implements AddBarMVP.View {

    @BindView(R.id.buttonAdd)
    Button buttonAdd;
    @BindView(R.id.editaddress)
    EditText editAddress;
    @BindView(R.id.editbar)
    EditText editbar;

    private AddBarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bar);
        ButterKnife.bind(this);
        presenter = new AddBarPresenter(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bar bar = new Bar();
                bar.setAdressBar(editAddress.getText().toString());
                bar.setNameBar(editbar.getText().toString());

                if(bar.getAdressBar().length()!=0 && bar.getNameBar().length()!=0)
                presenter.addFireBaseElement(bar);
                else
                    Toast.makeText(getApplicationContext(), "Name or Adress is too short!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void addElement() {
        Toast.makeText(this, "You added new BAR!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddBarActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
