package com.playground.app.medium_articles_app.data.source.remote

import com.playground.app.medium_articles_app.data.source.remote.model.ArticleChannelRss

interface ArticleApi {

    suspend fun getArticleChannel(): ArticleChannelRss
}