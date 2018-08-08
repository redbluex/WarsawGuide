package pl.redblue.warszawa.restaurant;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

import pl.redblue.warszawa.R;

public class AdapterRestaurant extends RecyclerView.Adapter<AdapterRestaurant.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Restaurant> restaurants;
    boolean clicked = true;


    AdapterRestaurant(Context context, List<Restaurant>restaurants){
        this.layoutInflater = LayoutInflater.from(context);
        this.restaurants = restaurants;

    }


    @NonNull
    @Override
    public AdapterRestaurant.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.restaurant_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRestaurant.ViewHolder holder, final int position) {
        Picasso.get().load(restaurants.get(position).getPhotoRestaurant()).into(holder.imageRestaurant);
        holder.nameRestaurant.setText(restaurants.get(position).getNameRestaurant());
        String likeRatioString = String.valueOf(restaurants.get(position).getLikeRatio());
        holder.likeRatio.setText(likeRatioString);
        if(clicked)
            holder.button.setImageResource(R.drawable.outline_thumb_up_black_24dp);
        if(clicked!=true)
            holder.button.setImageResource(R.drawable.baseline_thumb_up_black_24dp);


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("restaurants").child(restaurants.get(position).getIdRestaurant()).child("likeRatio");

                if(clicked!=true){
                    reference.setValue(restaurants.get(position).getLikeRatio() - 1);
                    String likeRatioString = String.valueOf(restaurants.get(position).getLikeRatio());
                    holder.likeRatio.setText(likeRatioString);
                    clicked = true;
                }
                else{
                    reference.setValue(restaurants.get(position).getLikeRatio() + 1);
                    String likeRatioString = String.valueOf(restaurants.get(position).getLikeRatio());
                    holder.likeRatio.setText(likeRatioString);
                    clicked = false;
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageRestaurant;
        TextView nameRestaurant;
        TextView likeRatio;
        ImageView button;

        public ViewHolder(View itemView) {
            super(itemView);
            imageRestaurant = (ImageView)itemView.findViewById(R.id.imageView);
            nameRestaurant = (TextView)itemView.findViewById(R.id.textNameRestaurant);
            likeRatio = (TextView)itemView.findViewById(R.id.textLikeRatio);
            button = (ImageView) itemView.findViewById(R.id.imageLike);

        }



    }


}
