package com.mainp.englishdictionaryver2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mainp.englishdictionaryver2.data.model.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM word_tbl LIMIT 10")
    fun getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWords(words: Word)

    @Update
    fun updateWords(words: Word)

    @Query("SELECT * FROM word_tbl WHERE isFavorite = TRUE")
    fun getFavoriteWords(): LiveData<List<Word>>

}
