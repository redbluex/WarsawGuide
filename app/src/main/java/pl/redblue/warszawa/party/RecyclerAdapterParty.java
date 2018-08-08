package pl.redblue.warszawa.party;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pl.redblue.warszawa.R;

public class RecyclerAdapterParty extends RecyclerView.Adapter<RecyclerAdapterParty.ViewHolder> {
    private List<Party> parties;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    RecyclerAdapterParty(Context context, List<Party> parties) {
        this.parties = parties;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.emlement_party_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameParty.setText(parties.get(position).getNameParty());
        holder.adressParty.setText(parties.get(position).getAdressParty());
        holder.dateParty.setText(parties.get(position).getDateParty());
        Picasso.get().load(parties.get(position).getPhotoParty()).resize(600,300).into(holder.photoParty);
    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameParty;
        TextView dateParty;
        TextView adressParty;
        ImageView photoParty;

        public ViewHolder(View itemView) {
            super(itemView);
            nameParty = (TextView)itemView.findViewById(R.id.textNameParty);
            dateParty = (TextView)itemView.findViewById(R.id.textDateParty);
            adressParty = (TextView)itemView.findViewById(R.id.textAdressParty);
            photoParty = (ImageView)itemView.findViewById(R.id.imagePhotoParty);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
