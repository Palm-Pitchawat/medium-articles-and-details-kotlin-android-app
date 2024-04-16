package com.playground.app.medium_articles_app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.playground.app.medium_articles_app.domain.model.Article
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {

    val articleChannelTitle = homeViewModel.articleChannelTitle.collectAsStateWithLifecycle().value
    val articleList = homeViewModel.articleList.collectAsStateWithLifecycle().value

    HomeContent(
        articleChannelTitle = articleChannelTitle,
        articleList = articleList
    )
}

@Composable
fun HomeContent(
    articleChannelTitle: String?,
    articleList: List<Article>?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (articleChannelTitle != null) {
            Text(
                text = articleChannelTitle,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }
        ArticleCardList(articleList)
    }
}

@Composable
fun ArticleCardList(articleList: List<Article>?) {
    if (articleList != null) {
        LazyColumn {
            itemsIndexed(articleList) { index, item ->
                ArticleCard(
                    article = item,
                    itemLastIndex = articleList.lastIndex,
                    itemCurrentIndex = index
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticleCard(
    article: Article,
    itemLastIndex: Int,
    itemCurrentIndex: Int
) {
    Column {
        Card(
            shape = RoundedCornerShape(1.5.dp),
            elevation = CardDefaults
                .cardElevation(
                    defaultElevation = 1.5.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    model = article.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(
                        width = 160.dp,
                        height = 100.dp
                    )
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = article.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = article.content,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    )
                }
            }
        }
        if (itemLastIndex != itemCurrentIndex) {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}