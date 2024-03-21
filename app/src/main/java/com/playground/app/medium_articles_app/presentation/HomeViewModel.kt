package com.playground.app.medium_articles_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playground.app.medium_articles_app.domain.model.Article
import com.playground.app.medium_articles_app.domain.usecase.GetArticlesUseCase
import com.playground.app.medium_articles_app.domain.usecase.UseCaseResponse
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _articleList = MutableLiveData<List<Article>>()
    val articleList: LiveData<List<Article>>
        get() = _articleList

    private val _articleChannelTitle = MutableLiveData<String?>()
    val articleChannelTitle: LiveData<String?>
        get() = _articleChannelTitle

    init {
        getArticles()
    }

    private fun getArticles() {
        _loading.value = true
        viewModelScope.launch {
            when(val result = getArticlesUseCase()) {
                is UseCaseResponse.Success -> {
                    _articleList.value = result.data.articles
                    _articleChannelTitle.value = result.data.channelTitle
                }
                is UseCaseResponse.Error -> {
                }
            }
        }
    }
}