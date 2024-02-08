package com.evoionosp.newspages.presentation.data.source

import com.evoionosp.newspages.presentation.data.api.ApiService
import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : NewsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadlines(country)
    }
}