package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CPUDao
{
    @Insert
    void insertCPU(CPU cpu);

    @Update
    void updateCPU(CPU cpu);

    @Delete
    void deleteCPU(CPU cpu);

    @Query("DELETE FROM cpu_table")
    void deleteAllCPUs ();

    @Query("SELECT * FROM cpu_table WHERE productType = 'cpu' ORDER BY price DESC")
    LiveData<List<CPU>> getAllCPUs();
}
