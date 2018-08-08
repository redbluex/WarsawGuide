package pl.redblue.warszawa.communication;

import java.util.List;

public interface CommunicationMVP  {
    interface View{
        void addAdapter(List list);
    }
    interface Presenter{
        void getTickets();
        void getAirports();
    }
}
