package com.katrinaann.restauranttop10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants;
    private RecyclerViewClickListener mListener;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants, RecyclerViewClickListener listener) {
        mRestaurants = restaurants;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, cuisineType, location, rating;
        public ImageView image;
        private RecyclerViewClickListener mListener;

        public RestaurantViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.restaurant_name);
            cuisineType = v.findViewById(R.id.restaurant_cuisineType);
            location = v.findViewById(R.id.restaurant_location);
            rating = v.findViewById(R.id.restaurant_rating);
            image = v.findViewById(R.id.restaurant_image);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_row, parent, false);
        return new RestaurantViewHolder(v, mListener);
    }


    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position){
        Restaurant restaurant  = mRestaurants.get(position);
        holder.name.setText(restaurant.getName());
        holder.cuisineType.setText(restaurant.getCuisineType());
        holder.location.setText(restaurant.getLocation());
        holder.rating.setText(String.valueOf(restaurant.getRating()));
        holder.image.setImageResource(restaurant.getImageID());
    }
    //Return the size of our dataset
    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }
}


