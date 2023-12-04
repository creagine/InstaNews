package com.rudiridho.instanews.core

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String
    ): Response<NewsResponse>

    @GET("v2/top-headlines/sources")
    suspend fun getNewsSources(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Response<NewsSourcesResponse>
}
