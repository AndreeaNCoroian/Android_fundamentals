package com.example.tripit;

//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TripListActivity extends AppCompatActivity {

    private TripViewModel tripViewModel;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        initializeDisplayContent();


    }

    private void initializeDisplayContent() {

        final RecyclerView recyclerTrips = (RecyclerView) findViewById(R.id.list_trips);
        TripRecycleAdapter adapter = new TripRecycleAdapter(this);
        recyclerTrips.setAdapter(adapter);
        final LinearLayoutManager tripsLayoutManager = new LinearLayoutManager(this);
        recyclerTrips.setLayoutManager(tripsLayoutManager);

        tripViewModel = new ViewModelProvider(this).get(TripViewModel.class);

        tripViewModel.getAlltrips().observe(this, new Observer<List<Trip>>() {
            @Override
            public void onChanged(@Nullable final List<Trip> trips) {
                // Update the cached copy of the words in the adapter
                adapter.setTrips(trips);
            }
        });

    }
}



