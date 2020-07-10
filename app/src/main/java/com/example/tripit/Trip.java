package com.example.tripit;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "trip_table")
public class Trip {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int tripId;

    private String tripName;

    private String tripDestination;

    private int price;

    @TypeConverters(DateConverter.class)
    private Date startDate;

    @TypeConverters(DateConverter.class)
    private Date endDate;

    private int rating;

    @Ignore
    private Bitmap picture;


    public Trip(String tripName, String tripDestination) {
        this.tripName = tripName;
        this.tripDestination = tripDestination;
    }

    //Getters & Setters

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripid) {
        this.tripId = tripid;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDestination() {
        return tripDestination;
    }

    public void setTripDestination(String tripDestination) {
        this.tripDestination = tripDestination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }





}
