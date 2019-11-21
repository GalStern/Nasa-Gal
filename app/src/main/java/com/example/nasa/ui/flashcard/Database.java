package com.example.nasa.ui.flashcard;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Bodies.class}, version = 1)
public abstract class Database extends RoomDatabase{
        public abstract SSBodiesDao ssBodiesDao();          // Replace BookDao with whatever you name your DAO
        private static Database instance;
        public static Database getInstance(Context context) {

            if(instance == null) {
                instance = Room.databaseBuilder(context, Database.class, "ssBodiesDb")
                        .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
                        //     This is NOT correct to do in a completed app.
                        //     Next week we will fix it, but for now this
                        //     line is necessary for the app to work.
                        //     This line will basically allow the database
                        //     queries to freeze the app.
                        .build();
            }
            return instance;
        }
}
