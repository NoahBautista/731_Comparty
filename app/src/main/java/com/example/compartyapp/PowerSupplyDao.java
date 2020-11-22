package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PowerSupplyDao
{
    @Insert
    void insertPowerSupply (PowerSupply powerSupply);

    @Update
    void updatePowerSupply(PowerSupply powerSupply);

    @Delete
    void deletePowerSupply(PowerSupply powerSupply);

    @Query("DELETE FROM powerSupply_table")
    void deleteAllPowerSupplies ();

    @Query("SELECT * FROM powerSupply_table WHERE productType = 'powerSupply' ORDER BY price DESC")
    LiveData<List<PowerSupply>> getAllPowerSupplies();
}
