package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MotherboardDao
{
    @Insert
    void insertMotherboard (Motherboard motherboard);

    @Update
    void updateMotherboard(Motherboard motherboard);

    @Delete
    void deleteMotherboard(Motherboard motherboard);

    @Query("DELETE FROM motherboard_table")
    void deleteAllMotherboards ();

    @Query("SELECT * FROM motherboard_table WHERE productType = 'motherboard' ORDER BY price DESC")
    LiveData<List<Motherboard>> getAllMotherboards();
}
