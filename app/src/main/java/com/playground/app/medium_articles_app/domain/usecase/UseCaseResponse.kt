package com.playground.app.medium_articles_app.domain.usecase

import java.lang.Exception

sealed interface UseCaseResponse<out T> {
    data class Success<T>(val data: T): UseCaseResponse<T>
    data class Error(val exception: Exception? = null) : UseCaseResponse<Nothing>
}