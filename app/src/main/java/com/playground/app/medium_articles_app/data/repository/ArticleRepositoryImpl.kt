package com.playground.app.medium_articles_app.data.repository

import com.playground.app.medium_articles_app.data.source.remote.ArticleApi
import com.playground.app.medium_articles_app.domain.model.ArticleChannel
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository

class ArticleRepositoryImpl(
    private val articleApi: ArticleApi,
): ArticleRepository {
    override suspend fun getArticles(): ArticleChannel {
        return articleApi.getArticleChannel()
    }
}