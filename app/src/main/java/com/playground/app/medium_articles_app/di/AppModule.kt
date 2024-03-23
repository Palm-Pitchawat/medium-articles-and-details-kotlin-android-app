package com.playground.app.medium_articles_app.di

import androidx.room.Room
import com.playground.app.medium_articles_app.data.repository.ArticleRepositoryImpl
import com.playground.app.medium_articles_app.data.source.local.database.ArticleDatabase
import com.playground.app.medium_articles_app.data.source.remote.ArticleApi
import com.playground.app.medium_articles_app.data.source.remote.ArticleApiImpl
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository
import com.playground.app.medium_articles_app.domain.usecase.GetArticleChannelFlowUseCase
import com.playground.app.medium_articles_app.domain.usecase.GetArticleChannelUseCase
import com.playground.app.medium_articles_app.presentation.ArticleDetailViewModel
import com.playground.app.medium_articles_app.presentation.HomeViewModel
import com.prof18.rssparser.RssParserBuilder
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Dispatchers.IO
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            ArticleDatabase::class.java, "medium_article"
        ).build()
            .articleChannelDao()
    }

    single {
        RssParserBuilder().build()
    }

    single<ArticleApi> {
        ArticleApiImpl(get(), get())
    }

    single<ArticleRepository> {
        ArticleRepositoryImpl(get(), get())
    }

    single {
        GetArticleChannelUseCase(get())
    }

    single {
        GetArticleChannelFlowUseCase(get())
    }

    viewModel { HomeViewModel(get(), get()) }

    viewModel { ArticleDetailViewModel() }
}