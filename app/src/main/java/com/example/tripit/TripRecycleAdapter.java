package com.example.tripit;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TripRecycleAdapter extends RecyclerView.Adapter<TripRecycleAdapter.ViewHolder>{

    private final Context mContext;
    private final LayoutInflater mlayoutInflater;
    private List<Trip> allTrips;

    public TripRecycleAdapter(Context mContext) {
        this.mContext = mContext;
        mlayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mlayoutInflater.inflate(R.layout.item_trip_list, viewGroup, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (allTrips != null) {
            Trip current = allTrips.get(i);
            viewHolder.getTextTrip().setText(current.getTripName());
            viewHolder.getTextDestination().setText(current.getTripDestination());
        } else {
            // Covers the case of data not being ready yet.
            viewHolder.getTextTrip().setText("No Trip");
        }
    }

    void setTrips(List<Trip> trips){
        allTrips = trips;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allTrips != null)
            return allTrips.size();
        else return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textTrip;
        private final TextView textDestination;

        public TextView getTextTrip() {
            return textTrip;
        }

        public TextView getTextDestination() {
            return textDestination;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            textTrip = (TextView) itemView.findViewById(R.id.text_trip);
            textDestination = (TextView) itemView.findViewById(R.id.text_destination);
        }
    }
}

