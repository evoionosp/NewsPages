package com.evoionosp.newspages.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.evoionosp.newspages.presentation.ui.components.EmptyStateComponent
import com.evoionosp.newspages.presentation.ui.components.Loader
import com.evoionosp.newspages.presentation.ui.components.NewsRowComponent
import com.evoionosp.newspages.presentation.ui.viewmodel.NewsViewModel
import com.evoionosp.newspages.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by newsViewModel.news.collectAsState()

    Log.d(TAG, "HomeScreen loaded")


    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )

    VerticalPager(
        state = pagerState,
        pageCount = newsResponse.let { if (it is ResourceState.Success) it.data.totalResults else 0 },
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->

        Log.d(TAG, "response: ${newsResponse}")
        when (newsResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Loading ...")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d(
                    TAG,
                    "Success: Status: ${response.status}TotalResults: ${response.totalResults} "
                )
                if (response.articles.isNotEmpty())
                    NewsRowComponent(page = page, article = response.articles[page])
                else EmptyStateComponent()
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Error: ${(newsResponse as ResourceState.Error).error}")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}