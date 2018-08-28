package pl.redblue.warszawa.bar;

import java.util.List;

public interface BarMVP {
    interface View{
        void addAdapter();
    }

    interface Presenter{
        void loadFireBaseDate();
        List<Bar> getBars();
    }
}
