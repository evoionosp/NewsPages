package com.evoionosp.newspages.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import com.evoionosp.newspages.presentation.ui.repository.NewsRepository
import com.evoionosp.newspages.utilities.Configs
import com.evoionosp.newspages.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news =
        MutableStateFlow<ResourceState<NewsResponse>>(ResourceState.Loading<NewsResponse>())
    val news: StateFlow<ResourceState<NewsResponse>> = _news


    init {
        getNews(Configs.COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadlines(country)
                .collectLatest { response ->
                    _news.value = response
                }
        }
    }

    companion object {
        const val TAG = "NewsViewModel"
    }
}