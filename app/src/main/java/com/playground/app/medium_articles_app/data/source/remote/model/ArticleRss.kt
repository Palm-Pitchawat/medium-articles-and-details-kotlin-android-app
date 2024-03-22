package com.playground.app.medium_articles_app.data.source.remote.model

import com.playground.app.medium_articles_app.data.source.local.model.ArticleEntity

data class ArticleRss (
    val title: String,
    val image: String,
    val imageReference: String,
    val htmlContent: String,
    val content: String
)

fun ArticleRss.asArticleEntity(articleChannelTitle: String) = ArticleEntity(
    title = title,
    image = image,
    imageReference = imageReference,
    htmlContent = htmlContent,
    content = content,
    articleChannelTitle = articleChannelTitle
)