package com.mainp.englishdictionaryver2.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mainp.englishdictionaryver2.data.model.Favorite
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.data.repository.DictionaryRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DictionaryViewModelFactory(
    private val repository: DictionaryRepositoryImpl,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DictionaryViewModel(repository) as T
    }
}

class DictionaryViewModel(private val repository: DictionaryRepositoryImpl) : ViewModel() {
    val words: LiveData<List<Word>> = repository.getAllWord()
    val factory: LiveData<List<Favorite>> = repository.getFavoriteWords()

    fun insertFavorite(favorite: Favorite){
        viewModelScope.launch {
            repository.insertFavorite(favorite)
        }
    }

    fun deleteFavorite(favorite: Favorite) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavorite(favorite)
        }
    }
}






