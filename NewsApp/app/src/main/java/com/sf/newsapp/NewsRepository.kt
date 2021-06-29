package com.sf.newsapp

import com.sf.NewsModel

class NewsRepository {
    private val service = RetrofitClient.getClient().create(NewsService::class.java)

    suspend fun getNewsList(): List<NewsModel> {
        return service.getNewsList()
    }

    fun updateFavoriteItem(pos: Int) {
        //todo must update in dataBase remove or add
    }
}