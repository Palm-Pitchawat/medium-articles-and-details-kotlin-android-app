package com.playground.app.medium_articles_app.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface UseCaseResponse<out T> {
    data class Success<T>(val data: T? = null): UseCaseResponse<T>
    data class Error(val exception: Throwable? = null) : UseCaseResponse<Nothing>
}

sealed interface UseCaseResponseFlow<out T> {
    data object Loading: UseCaseResponseFlow<Nothing>
    data class Success<T>(val data: T): UseCaseResponseFlow<T>
    data class Error(val exception: Throwable? = null) : UseCaseResponseFlow<Nothing>
}

fun <T> Flow<T>.asUseCaseResponseFlow(): Flow<UseCaseResponseFlow<T>> = map<T, UseCaseResponseFlow<T>> { UseCaseResponseFlow.Success(it) }
    .onStart { emit(UseCaseResponseFlow.Loading) }
    .catch { emit(UseCaseResponseFlow.Error(it)) }