package com.evoionosp.newspages.presentation.ui.repository

import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import com.evoionosp.newspages.presentation.data.source.NewsDataSource
import com.evoionosp.newspages.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

//    suspend fun getNewsHeadlines(country: String): Response<NewsResponse> {
//        return newsDataSource.getNewsHeadline(country)
//    }

    suspend fun getNewsHeadlines(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if (response.isSuccessful) {
                response.body().let {
                    when (it) {
                        null -> emit(ResourceState.Error("Error: Null news response"))
                        else -> emit(ResourceState.Success(it))
                    }
                }
            } else emit(ResourceState.Error("Error: request not successful"))
        }.catch { err ->
            emit(ResourceState.Error("Error: ${err.localizedMessage ?: "some unknown error in flow"}"))
        }
    }
}