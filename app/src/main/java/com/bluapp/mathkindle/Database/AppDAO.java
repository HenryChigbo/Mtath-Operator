package com.bluapp.mathkindle.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bluapp.mathkindle.Utils.History;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface AppDAO {
    @Insert(onConflict = REPLACE)
    public void insert(History history);

    @Query("select * from history")
    LiveData<List<History>> getAllHistory();
}