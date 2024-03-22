package com.playground.app.medium_articles_app.domain.model

data class ArticleChannel(
    val channelTitle: String,
    val articles: List<Article>
)