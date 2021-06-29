package com.sf.newsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sf.NewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    fun updateFavoriteItem(pos: Int) {
        newsRepository.updateFavoriteItem(pos)
    }

    private val _newsList: MutableLiveData<List<NewsModel>> = MutableLiveData()
    val newsList: LiveData<List<NewsModel>>
        get() = _newsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _newsList.postValue(newsRepository.getNewsList())
        }
    }
}