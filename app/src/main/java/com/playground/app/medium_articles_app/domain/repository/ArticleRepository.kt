package com.playground.app.medium_articles_app.domain.repository

import com.playground.app.medium_articles_app.domain.model.ArticleChannel
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    suspend fun getArticleChannel()

    fun getArticleChannelFlow(): Flow<ArticleChannel?>
}