package com.mainp.englishdictionaryver2.data.repository

import androidx.lifecycle.LiveData
import com.mainp.englishdictionaryver2.data.dao.FavoriteDao
import com.mainp.englishdictionaryver2.data.dao.WordDao
import com.mainp.englishdictionaryver2.data.model.Favorite
import com.mainp.englishdictionaryver2.data.model.Word

class DictionaryRepositoryImpl(private val wordDao: WordDao, private val factoryDao: FavoriteDao):DictionaryRepository {
    override fun getAllWord(): LiveData<List<Word>> = wordDao.getAllWords()

    override suspend fun insertFavorite(favorite: Favorite){
        factoryDao.insertFavorite(favorite)
    }
    override fun getFavoriteWords(): LiveData<List<Favorite>> = factoryDao.getAllFavorites()

    override fun deleteFavorite(favorite: Favorite){
        factoryDao.deleteFavorite(favorite)
    }
}