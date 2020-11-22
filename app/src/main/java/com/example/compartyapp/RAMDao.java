package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RAMDao
{
    @Insert
    void insertRAM (RAM ram);

    @Update
    void updateRAM(RAM ram);

    @Delete
    void deleteRAM(RAM ram);

    @Query("DELETE FROM ram_table")
    void deleteAllRAMs ();

    @Query("SELECT * FROM ram_table WHERE productType = 'ram' ORDER BY price DESC")
    LiveData<List<RAM>> getAllRAMs();
}
