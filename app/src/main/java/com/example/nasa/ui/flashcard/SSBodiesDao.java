package com.example.nasa.ui.flashcard;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SSBodiesDao {

    // Data Access Object for books.
    // Here I define all my methods that you are allowed to use to access the books table in the
    // database.
    //
    // The methods are annotated with @Query("SQL code"), essentially saying whenever this method
    // is called, run this SQL query and return the results.

    @Query("SELECT * FROM bodies")
    List<Bodies> getAll();


    // Notice in this query where it has ":isbn". This notation means that we substitute a value
    // in the place of :isbn. What value is put in there? The long isbn that you can see in the
    // method parameter.
    @Query("SELECT * FROM bodies WHERE name = :name")
    Bodies findBodyByName(String name);


    // The onConflictStrategy determines how to handle when duplicate primary keys are inserted.
    // Without this, your app will only run once, and crash every time after because it keeps trying
    // to insert already existing primary keys.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Bodies> bodies);

    @Delete
    void delete(Bodies bodies);
}
