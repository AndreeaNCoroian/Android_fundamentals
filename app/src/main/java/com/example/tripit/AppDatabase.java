package com.example.tripit;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Trip.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {


    public abstract TripDao tripDao();

    private static  AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(final Context context) {
        if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "trip_database")
                            .build();
            }
        return INSTANCE;
    }



    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {

            super.onOpen(db);

            TripDao dao = INSTANCE.tripDao();

            Trip trip = new Trip("First Trip","Trip1 Destination");
            Trip trip2 = new Trip("Second Trip","Trip2 Destination");
            Trip trip3 = new Trip("Third Trip","Trip3 Destination");

            dao.insertTrip(trip);
            dao.insertTrip(trip2);
            dao.insertTrip(trip3);

        }
    };


}
