package com.evoionosp.newspages.presentation.data.source

import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}