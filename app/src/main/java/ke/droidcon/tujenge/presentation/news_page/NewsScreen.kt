package ke.droidcon.tujenge.presentation.news_page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NewsScreen(){

    val newsScreenViewModel: NewsScreenViewModel = hiltViewModel();

    val newsList by newsScreenViewModel.newsState.collectAsState()

    // Use the observed state in your Compose UI
    LazyColumn {
        items(newsList) { newsItem ->
            NewsCard(newsItem = newsItem)
        }
    }

}