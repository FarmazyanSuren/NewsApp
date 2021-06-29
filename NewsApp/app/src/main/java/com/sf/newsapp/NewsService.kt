package com.sf.newsapp

import com.sf.NewsModel
import retrofit2.http.GET

interface NewsService {

    @GET("api/v2/articles/")
    suspend fun getNewsList(): List<NewsModel>
}