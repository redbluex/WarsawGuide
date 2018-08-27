package pl.redblue.warszawa.communication;

import java.util.ArrayList;
import java.util.List;

public class AirportPresenter implements AirportMVP.Presenter {
    private AirportModel airportModel;
    private List<Airport> airports;
    private AirportMVP.View view;
    AirportPresenter(AirportMVP.View view){
        this.view = view;
        airportModel = new AirportModel();
        airports = airportModel.giveAirport();
    }


    @Override
    public List<Airport> getAirports() {
        return airports;
    }

    @Override
    public void setAdapter() {
        view.addAdapter();
    }


}
