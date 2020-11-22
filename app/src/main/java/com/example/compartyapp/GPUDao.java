package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GPUDao
{
    @Insert
    void insertGPU (GPU gpu);

    @Update
    void updateGPU(GPU gpu);

    @Delete
    void deleteGPU(GPU gpu);

    @Query("DELETE FROM gpu_table")
    void deleteAllGPUs ();

    @Query("SELECT * FROM gpu_table WHERE productType = 'gpu' ORDER BY price DESC")
    LiveData<List<GPU>> getAllGPUs();
}
