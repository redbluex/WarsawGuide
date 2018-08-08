package pl.redblue.warszawa.bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.redblue.warszawa.R;
import pl.redblue.warszawa.places.PlaceRecyclerAdapter;

public class RecyclerAdapterBar extends RecyclerView.Adapter<RecyclerAdapterBar.ViewHolder> {

    private List<Bar> bars;
    private Context context;
    private ItemClick itemClick;

    RecyclerAdapterBar(List <Bar> bars, Context context){
        this.bars = bars;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterBar.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bar_single_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterBar.ViewHolder holder, int position) {
        holder.nameBar.setText(bars.get(position).getNameBar());
        holder.adressBar.setText(bars.get(position).getAdressBar());
        double thumbs = bars.get(position).getThumbsUp() / (bars.get(position).getThumbsUp() + bars.get(position).getThumbsDown()) * 100;
        int thumbsInt = (int)thumbs;
        holder.thumbsRatio.setText(thumbsInt + " %");
    }

    @Override
    public int getItemCount() {
        return bars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameBar;
        TextView adressBar;
        TextView thumbsRatio;

        public ViewHolder(View itemView) {
            super(itemView);
            nameBar = (TextView)itemView.findViewById(R.id.textNameBar);
            adressBar = (TextView)itemView.findViewById(R.id.textAdressBar);
            thumbsRatio = (TextView)itemView.findViewById(R.id.textThumbsRatio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClick != null) itemClick.onItemClick(view, getAdapterPosition());
        }
    }

    void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    interface ItemClick{
        void onItemClick(View view, int position);
    }
}
