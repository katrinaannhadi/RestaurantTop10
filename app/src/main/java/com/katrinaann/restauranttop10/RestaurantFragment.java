package com.katrinaann.restauranttop10;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantFragment extends Fragment {

    private Restaurant mRestaurant;

    public RestaurantFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restaurant, container, false);
        int position = 0;


        //Initialising views
        TextView name = v.findViewById(R.id.restaurant_name);
        TextView cuisineType = v.findViewById(R.id.tvCuisineTypeField);
        TextView location = v.findViewById(R.id.tvLocationField);
        TextView rating = v.findViewById(R.id.tvRatingField);
        TextView about = v.findViewById(R.id.tvAboutField);
        ImageView image = v.findViewById(R.id.imageView);
        ImageView search = v.findViewById(R.id.ivSearch);

        Intent intent = getActivity().getIntent();
        position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0);
        mRestaurant = Restaurant.getRestaurant().get(position);

        name.setText(mRestaurant.getName());
        cuisineType.setText((mRestaurant.getCuisineType()));
        location.setText(mRestaurant.getLocation());
        rating.setText(String.valueOf(mRestaurant.getRating()));
        about.setText(String.valueOf(mRestaurant.getAbout()));
        image.setImageResource(mRestaurant.getImageID());
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchRestaurant(mRestaurant.getName(),mRestaurant.getLocation());

            }

        });
        return v;
    }
    private void searchRestaurant(String name, String location){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name + " " + location));
        startActivity(intent);
    }
    private void setImage(String url, final View view){

    }
}
