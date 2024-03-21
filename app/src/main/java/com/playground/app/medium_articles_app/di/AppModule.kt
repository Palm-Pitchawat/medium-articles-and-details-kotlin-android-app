package com.playground.app.medium_articles_app.di

import com.playground.app.medium_articles_app.data.repository.ArticleRepositoryImpl
import com.playground.app.medium_articles_app.data.source.remote.ArticleApi
import com.playground.app.medium_articles_app.data.source.remote.ArticleApiImpl
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository
import com.playground.app.medium_articles_app.domain.usecase.GetArticlesUseCase
import com.playground.app.medium_articles_app.presentation.HomeViewModel
import com.prof18.rssparser.RssParserBuilder
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Dispatchers.IO
    }

    single {
        RssParserBuilder().build()
    }

    single<ArticleApi> {
        ArticleApiImpl(get(), get())
    }

    single<ArticleRepository> {
        ArticleRepositoryImpl(get())
    }

    single {
        GetArticlesUseCase(get())
    }

    viewModel { HomeViewModel(get()) }
}