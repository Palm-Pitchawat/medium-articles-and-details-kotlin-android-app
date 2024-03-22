package com.playground.app.medium_articles_app.data.source.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.playground.app.medium_articles_app.domain.model.ArticleChannel

data class ArticleChannelWithArticle(
    @Embedded
    val articleEntity: ArticleChannelEntity,
    @Relation(
        parentColumn = "channel_title",
        entityColumn = "article_channel_title"
    )
    val articleEntityList: List<ArticleEntity>
)

fun ArticleChannelWithArticle.asArticleChannel() = ArticleChannel(
    channelTitle = articleEntity.channelTitle,
    articles = articleEntityList.map(ArticleEntity::asArticle)
)