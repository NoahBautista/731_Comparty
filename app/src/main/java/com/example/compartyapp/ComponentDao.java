package com.example.compartyapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ComponentDao
{
    @Insert
    void insert (Component component);

  @Query("SELECT * FROM component_table ORDER BY price DESC")
  LiveData<List<Component>> getAllComponents();
}
