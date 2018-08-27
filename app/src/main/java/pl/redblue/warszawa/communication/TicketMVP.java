package pl.redblue.warszawa.communication;

import java.util.List;

public interface TicketMVP {
    interface View{
        void addAdapter(List list);
    }
    interface Presenter{
        void getTickets();
    }
}
