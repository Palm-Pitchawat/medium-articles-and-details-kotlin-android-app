package com.playground.app.medium_articles_app.data.source.remote.model

import com.playground.app.medium_articles_app.data.source.local.model.ArticleChannelEntity

data class ArticleChannelRss(
    val channelTitle: String,
    val articles: List<ArticleRss>
)

fun ArticleChannelRss.asArticleChannelEntity() = ArticleChannelEntity(
    channelTitle = channelTitle
)

fun ArticleChannelRss.asArticleEntityList() = articles.map {
    it.asArticleEntity(channelTitle)
}
