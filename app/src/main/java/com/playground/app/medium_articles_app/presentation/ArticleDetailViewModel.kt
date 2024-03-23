package com.playground.app.medium_articles_app.presentation

import androidx.lifecycle.ViewModel
import com.playground.app.medium_articles_app.domain.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArticleDetailViewModel: ViewModel() {

    private val _article = MutableStateFlow<Article?>(null)
    val article = _article.asStateFlow()

    fun setArticle(article: Article) {
        _article.value = article
    }
}