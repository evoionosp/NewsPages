package com.evoionosp.newspages.presentation.data.api


import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import com.evoionosp.newspages.utilities.Configs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = Configs.API_KEY
    ): Response<NewsResponse>


}

/*
https://newsapi.org/v2/top-headlines?country=us&apiKey=dc28fa0196a849a08533697c7b97e9dd
 */