package com.evoionosp.newspages.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.evoionosp.newspages.presentation.R
import com.evoionosp.newspages.presentation.data.entity.Article
import com.evoionosp.newspages.presentation.data.entity.NewsResponse
import com.evoionosp.newspages.presentation.data.entity.Source
import com.evoionosp.newspages.presentation.ui.theme.Purple40


const val TAG = "AppComponents"

@Composable
fun Loader() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier =
            Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Image(
            painter = painterResource(R.drawable.empty_screen_logo),
            contentDescription = "No News TO Display"
        )
    }
}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) {
            RowWithDescription(
                title = it.title ?: "NO_TITLE",
                description = it.description ?: "NO_DESCRIPTION",
                onClick = {
                    Log.d(TAG, "clickedOn: ${it.url}")
                }
            )
        }
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop,
            model = article.urlToImage,
            error = painterResource(id = R.drawable.baseline_image_not_supported_240),
            placeholder = painterResource(id = R.drawable.outline_access_time_240),
            contentDescription = article.author
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = article.title ?: "NO_TITLE",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        article.description?.let {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(
            modifier = Modifier
                .height(0.dp)
                .weight(weight = 1F)
        )

        article.author?.let { it ->
            Text(
                text = "Author: $it",
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        article.publishedAt?.let {
            Text(
                text = "PublishedOn: $it",
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

    }
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    NewsRowComponent(
        page = 0, article = Article(
            author = "Oren Liebermann, Natasha Bertrand",
            title = "US destroyed or damaged 84 of 85 targets in Iraq and Syria, officials say; no indications of Iranian casualties - CNN",
            description = "The US destroyed or damaged 84 out of 85 targets in its sweeping series of airstrikes on Friday in Syria and Iraq, according to two US defense officials, with no current indications of Iranian casualties.",
            url = "https://www.cnn.com/2024/02/04/politics/us-damage-assessment-syria-iraq/index.html",
            urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/2024-02-03t115238z-549671722-rc2wu5atigl3-rtrmadp-3-israel-palestinians-iraq-aftermath.JPG?c=16x9&q=w_800,c_fill",
            publishedAt = "2024-02-05T00:09:00Z",
            source = Source(id = "cnn", name = "CNN"),
            content = "The US destroyed or damaged 84 out of 85 targets in its sweeping series of airstrikes on Friday in Syria and Iraq, according to two US defense officials, with no indications of Iranian casualties."
        )
    )
}

@Composable
fun RowWithDescription(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}