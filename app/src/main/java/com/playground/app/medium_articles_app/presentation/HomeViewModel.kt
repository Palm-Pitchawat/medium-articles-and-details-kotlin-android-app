package com.playground.app.medium_articles_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.app.medium_articles_app.domain.model.Article
import com.playground.app.medium_articles_app.domain.usecase.GetArticleChannelFlowUseCase
import com.playground.app.medium_articles_app.domain.usecase.GetArticleChannelUseCase
import com.playground.app.medium_articles_app.domain.usecase.UseCaseResponseFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getArticleChannelUseCase: GetArticleChannelUseCase,
    getArticleChannelFlowUseCase: GetArticleChannelFlowUseCase
) : ViewModel() {

    val articleList: StateFlow<List<Article>?> = getArticleChannelFlowUseCase().map {
        if (it is UseCaseResponseFlow.Success) {
            it.data?.articles
        } else {
            null
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    val articleChannelTitle: StateFlow<String?> = getArticleChannelFlowUseCase().map {
        if (it is UseCaseResponseFlow.Success) {
            it.data?.channelTitle
        } else {
            null
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    init {
        getArticles()
    }

    private fun getArticles() {
        _loading.value = true
        viewModelScope.launch {
            getArticleChannelUseCase().also {
                _loading.value = false
            }
        }
    }
}