package com.playground.app.medium_articles_app.data.source.local.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.playground.app.medium_articles_app.data.source.local.model.ArticleChannelEntity
import com.playground.app.medium_articles_app.data.source.local.model.ArticleChannelWithArticle
import com.playground.app.medium_articles_app.data.source.local.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleChannelDao {

    @Upsert
    suspend fun upsertArticleChannel(articleChannelEntity: ArticleChannelEntity)
    @Upsert
    suspend fun upsertArticleList(articleList: List<ArticleEntity>)

    @Transaction
    @Query("SELECT * FROM article_channel WHERE channel_title = :channelTitle")
    fun getArticleChannel(channelTitle: String = "Stories by Vee PRIMO on Medium"): Flow<ArticleChannelWithArticle?>
}