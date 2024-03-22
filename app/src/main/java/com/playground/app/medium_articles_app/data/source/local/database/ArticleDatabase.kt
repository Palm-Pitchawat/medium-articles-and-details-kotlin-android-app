package com.playground.app.medium_articles_app.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.playground.app.medium_articles_app.data.source.local.model.ArticleChannelEntity
import com.playground.app.medium_articles_app.data.source.local.model.ArticleEntity

@Database(entities = [ArticleChannelEntity::class, ArticleEntity::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleChannelDao(): ArticleChannelDao
}