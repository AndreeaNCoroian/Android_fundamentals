package com.example.tripit;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TripRepository {

    private TripDao tripDao;
    private LiveData<List<Trip>> allTrips;

    TripRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        tripDao = db.tripDao();
        allTrips = tripDao.getAlphabetizedTrips();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Trip>> getAllTrips() {
        return allTrips;
    }

    void insert(Trip trip) {
        tripDao.insertTrip(trip);
    }

    void update(Trip trip){
        tripDao.updateTrip(trip);
    }
}