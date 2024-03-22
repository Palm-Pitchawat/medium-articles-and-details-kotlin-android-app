package com.playground.app.medium_articles_app.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "article_channel",
)
data class ArticleChannelEntity(
    @PrimaryKey
    @ColumnInfo(name = "channel_title")
    val channelTitle: String,
)