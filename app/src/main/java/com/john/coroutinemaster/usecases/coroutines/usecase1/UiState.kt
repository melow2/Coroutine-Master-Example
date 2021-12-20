package com.john.coroutinemaster.usecases.coroutines.usecase1

import com.john.coroutinemaster.mock.AndroidVersion

sealed class UiState {
    object Loading : UiState()
    data class Success(val recentVersions: List<AndroidVersion>) : UiState()
    data class Error(val message: String) : UiState()
}