package com.tdtxt.auf.tdtxt;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

//How the program will access the "word_table"
@Dao        //Data Access Object
public interface WordDao {
    @Insert         //Insert a new Word into the db
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();                   //How to query

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();


}
