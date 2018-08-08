package pl.redblue.warszawa.places;

import java.util.List;

public interface PlacesMVP {
    interface View{
        void addAdapter(List<Place> places);
    }
    interface Presenter{
        void loadData();
    }
}
