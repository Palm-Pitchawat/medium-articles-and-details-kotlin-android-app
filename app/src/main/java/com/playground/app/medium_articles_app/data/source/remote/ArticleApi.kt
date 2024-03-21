package com.playground.app.medium_articles_app.data.source.remote

import com.playground.app.medium_articles_app.domain.model.ArticleChannel

interface ArticleApi {

    suspend fun getArticleChannel(): ArticleChannel
}