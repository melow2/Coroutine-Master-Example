package com.john.coroutinemaster.usecases.coroutines.usecase7.rx

import com.john.coroutinemaster.mock.VersionFeatures

sealed class UiState {
    object Loading : UiState()
    data class Success(val versionFeatures: List<VersionFeatures>) : UiState()
    data class Error(val message: String) : UiState()
}