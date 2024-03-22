package com.playground.app.medium_articles_app.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.playground.app.medium_articles_app.domain.model.Article

@Entity(
    tableName = "article",
    foreignKeys = [
        ForeignKey(
            entity = ArticleChannelEntity::class,
            parentColumns = ["channel_title"],
            childColumns = ["article_channel_title"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ArticleEntity(
    @PrimaryKey
    val title: String,
    val image: String,
    @ColumnInfo(name = "image_reference")
    val imageReference: String,
    @ColumnInfo(name = "html_content")
    val htmlContent: String,
    val content: String,
    @ColumnInfo(name = "article_channel_title")
    val articleChannelTitle: String
)

fun ArticleEntity.asArticle() = Article(
    title = title,
    image = image,
    imageReference = imageReference,
    htmlContent = htmlContent,
    content = content
)
