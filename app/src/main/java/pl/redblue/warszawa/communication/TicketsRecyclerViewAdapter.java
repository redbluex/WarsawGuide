package pl.redblue.warszawa.communication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.redblue.warszawa.R;


public class TicketsRecyclerViewAdapter extends RecyclerView.Adapter<TicketsRecyclerViewAdapter.ViewHolder>{

    private List<SingleTicket> list;
    private LayoutInflater layoutInflater;

    public TicketsRecyclerViewAdapter( List<SingleTicket> list){
        this.list = list;
    }

    @NonNull
    @Override
    public TicketsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_ticket_one, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.ticketName.setText(list.get(position).getNameTicket());
        holder.ticketDescription.setText(list.get(position).getDescriptionTicket());
        holder.ticketImage.setImageResource(list.get(position).getImageResources());
        holder.ticketPrice.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ticketName;
        TextView ticketDescription;
        ImageView ticketImage;
        TextView ticketPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ticketName = (TextView)itemView.findViewById(R.id.ticketName);
            ticketDescription = (TextView)itemView.findViewById(R.id.ticketDescription);
            ticketImage = (ImageView) itemView.findViewById(R.id.imageTicket);
            ticketPrice = (TextView)itemView.findViewById(R.id.ticketPrice);
        }
    }
}
