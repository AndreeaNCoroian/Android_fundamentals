package com.example.tripit;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface TripDao {

    @Query("Select * from trip_table")
    List<Trip> getAllTrips();

    @Query("SELECT * from trip_table ORDER BY tripName ASC")
    LiveData<List<Trip>> getAlphabetizedTrips();

    @Insert
    void insertTrip(Trip trip);

    @Delete
    void deleteTrip(Trip trip);

    @Update
    void updateTrip(Trip trip);

}
