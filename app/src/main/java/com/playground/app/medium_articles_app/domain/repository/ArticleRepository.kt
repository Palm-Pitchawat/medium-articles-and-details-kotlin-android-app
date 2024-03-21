package com.playground.app.medium_articles_app.domain.repository

import com.playground.app.medium_articles_app.domain.model.ArticleChannel

interface ArticleRepository {

    suspend fun getArticles(): ArticleChannel
}