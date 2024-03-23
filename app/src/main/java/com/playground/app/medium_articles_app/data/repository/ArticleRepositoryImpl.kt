package com.playground.app.medium_articles_app.data.repository

import com.playground.app.medium_articles_app.data.source.local.database.ArticleChannelDao
import com.playground.app.medium_articles_app.data.source.local.model.asArticleChannel
import com.playground.app.medium_articles_app.data.source.remote.ArticleApi
import com.playground.app.medium_articles_app.data.source.remote.model.asArticleChannelEntity
import com.playground.app.medium_articles_app.data.source.remote.model.asArticleEntityList
import com.playground.app.medium_articles_app.domain.model.ArticleChannel
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val articleApi: ArticleApi,
    private val articleChannelDao: ArticleChannelDao
): ArticleRepository {

    override fun getArticleChannelFlow(): Flow<ArticleChannel?> {
        return articleChannelDao.getArticleChannel().distinctUntilChanged().map {
            it?.asArticleChannel()
        }
    }

    override suspend fun getArticleChannel() {
        val articleChannel = articleApi.getArticleChannel()
        articleChannelDao.upsertArticleChannel(articleChannel.asArticleChannelEntity())
        articleChannelDao.upsertArticleList(articleChannel.asArticleEntityList())
    }
}