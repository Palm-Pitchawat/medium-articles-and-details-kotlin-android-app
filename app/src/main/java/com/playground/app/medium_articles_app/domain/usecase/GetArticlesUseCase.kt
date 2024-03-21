package com.playground.app.medium_articles_app.domain.usecase

import com.playground.app.medium_articles_app.domain.model.ArticleChannel
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository

class GetArticlesUseCase(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(): UseCaseResponse<ArticleChannel> {
        return try {
            val articleChannel = articleRepository.getArticles()
            UseCaseResponse.Success(articleChannel)
        } catch (ex: Exception) {
            UseCaseResponse.Error(ex)
        }
    }
}