package com.mainp.englishdictionaryver2.data.repository

import androidx.lifecycle.LiveData
import com.mainp.englishdictionaryver2.data.model.Favorite
import com.mainp.englishdictionaryver2.data.model.Word


interface DictionaryRepository {
    suspend fun insertFavorite(favorite: Favorite)
    fun getAllWord(): LiveData<List<Word>>
    fun getFavoriteWords(): LiveData<List<Favorite>>
    fun deleteFavorite(favorite: Favorite)
}