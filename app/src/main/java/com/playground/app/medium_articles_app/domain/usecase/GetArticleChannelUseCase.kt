package com.playground.app.medium_articles_app.domain.usecase

import com.playground.app.medium_articles_app.domain.repository.ArticleRepository

class GetArticleChannelUseCase(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(): UseCaseResponse<Nothing> {
        return try {
            articleRepository.getArticleChannel()
            UseCaseResponse.Success()
        } catch (ex: Exception) {
            UseCaseResponse.Error(ex)
        }
    }
}