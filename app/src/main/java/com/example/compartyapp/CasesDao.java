package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CasesDao
{
    @Insert
    void insertCases(Cases cases);

    @Update
    void updateCases(Cases cases);

    @Delete
    void deleteCases(Cases cases);

    @Query("DELETE FROM cases_table")
    void deleteAllCases ();

    @Query("SELECT * FROM cases_table WHERE productType = 'cases' ORDER BY price DESC")
    LiveData<List<Cases>> getAllCases();
}
