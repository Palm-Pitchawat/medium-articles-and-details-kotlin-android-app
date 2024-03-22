package com.playground.app.medium_articles_app.domain.usecase

import com.playground.app.medium_articles_app.domain.model.ArticleChannel
import com.playground.app.medium_articles_app.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class GetArticleChannelFlowUseCase(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke(): Flow<UseCaseResponseFlow<ArticleChannel?>> =
        articleRepository.getArticleChannelFlow().asUseCaseResponseFlow()
}
