package pl.redblue.warszawa.communication;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class CommunicationPresenter implements CommunicationMVP.Presenter {
    private CommunicationMVP.View view;
    private TicketModel ticketModel = new TicketModel();

    CommunicationPresenter(CommunicationMVP.View view){
        this.view = view;
    }

    @Override
    public void getTickets() {
        view.addAdapter(ticketModel.giveTickets());
    }

    @Override
    public void getAirports() {
        view.addAdapter(ticketModel.giveAirport());
    }
}
