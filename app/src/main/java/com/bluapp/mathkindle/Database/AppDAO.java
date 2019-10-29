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
     void insert(History history);

    @Query("select * from history WHERE arithmeticoperator = :operator AND attempteddate = :date")
    LiveData<List<History>> getAllHistory(String operator, String date);

    @Query("select * from history")
    List<History> getAllDate();

}