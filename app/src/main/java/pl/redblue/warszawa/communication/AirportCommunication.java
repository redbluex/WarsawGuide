package pl.redblue.warszawa.communication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import pl.redblue.warszawa.R;

public class AirportCommunication extends Fragment implements AdapterView.OnItemSelectedListener, AirportMVP.View{

    AirportPresenter presenter;
    TextView nameAirport, adressAirport, descriptionAirport, transportAirport, priceAirport;
    Spinner spinner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.airportfragment_layout, container, false);
        presenter = new AirportPresenter(this);
        spinner = (Spinner)view.findViewById(R.id.spinnerAirport);
        nameAirport = (TextView)view.findViewById(R.id.textNameAirport);
        adressAirport = (TextView)view.findViewById(R.id.textAdressAirport);
        descriptionAirport = (TextView)view.findViewById(R.id.textDescriptionAirport);
        transportAirport = (TextView)view.findViewById(R.id.textTransport);
        priceAirport = (TextView)view.findViewById(R.id.textTransportPrice);
        presenter.setAdapter();
        return view;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nameAirport.setText(presenter.getAirports().get(position).getNameAirport());
                adressAirport.setText(presenter.getAirports().get(position).getAdress());
                descriptionAirport.setText(presenter.getAirports().get(position).getDescription());
                transportAirport.setText(presenter.getAirports().get(position).getTransport());
                priceAirport.setText(presenter.getAirports().get(position).getTransportPrice());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void addAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.airports, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
}
