package pl.redblue.warszawa.communication;

public class TicketPresenter implements TicketMVP.Presenter {

    private TicketModel ticketModel;
    private TicketMVP.View view;

    TicketPresenter(TicketMVP.View view){
        this.view = view;
        ticketModel = new TicketModel();
    }

    @Override
    public void getTickets() {
        view.addAdapter(ticketModel.giveTickets());
    }
}
