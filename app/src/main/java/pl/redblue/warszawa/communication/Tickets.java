package pl.redblue.warszawa.communication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.redblue.warszawa.R;


public class Tickets extends Fragment implements CommunicationMVP.View {

    private CommunicationPresenter presenter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.ticketRecycler);
        presenter = new CommunicationPresenter(this);
        presenter.getTickets();
        return view;
    }


    @Override
    public void addAdapter(List list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        TicketsRecyclerViewAdapter ticketsRecyclerViewAdapter;
        ticketsRecyclerViewAdapter = new TicketsRecyclerViewAdapter(list);
        recyclerView.setAdapter(ticketsRecyclerViewAdapter);
    }
}
