package pl.redblue.warszawa.places;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import pl.redblue.warszawa.R;
import pl.redblue.warszawa.main.MenuRecyclerViewAdapter;

public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Place> places;
    private ItemClickListener itemClickListener;


    PlaceRecyclerAdapter(Context context, List<Place>places){
        this.layoutInflater = LayoutInflater.from(context);
        this.places = places;
    }


    @NonNull
    @Override
    public PlaceRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlaceRecyclerAdapter.ViewHolder holder, int position) {

        holder.textNamePlace.setText(places.get(position).getName());
        Picasso.get().load(places.get(position).getPhotoLink()).resize(400,400).into(holder.imagePlace);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagePlace;
        TextView textNamePlace;

        ViewHolder(View itemView) {
            super(itemView);
            imagePlace = (ImageView)itemView.findViewById(R.id.imagePlace);
            textNamePlace = (TextView)itemView.findViewById(R.id.textNamePlace);
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
