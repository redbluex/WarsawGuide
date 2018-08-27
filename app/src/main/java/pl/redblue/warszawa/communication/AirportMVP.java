package pl.redblue.warszawa.communication;

import java.util.List;

public interface AirportMVP {
    interface View{
        void addAdapter();
    }
    interface Presenter{
        List<Airport> getAirports();
        void setAdapter();
    }
}
