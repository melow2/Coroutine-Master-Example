package com.john.coroutinemaster.usecases.coroutines.usecase6

import androidx.lifecycle.viewModelScope
import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class RetryNetworkRequestViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest() {
        uiState.value = UiState.Loading

        viewModelScope.launch {
            val numberOfRetries = 2
            retry(numberOfRetries) {
                try {
                    loadRecentAndroidVersion()
                } catch (e: Exception) {
                    Timber.e(e)
                    uiState.value = UiState.Error("Network request failed!")
                }
            }
        }
    }

    private suspend fun <T> retry(
        numberOfRetries: Int,
        initialDelayMillis: Long = 100,
        maxDelayMillis: Long = 1000,
        factor: Double = 2.0,
        block: suspend () -> T
    ): T {
        var currentDelay = initialDelayMillis
        repeat(numberOfRetries) {
            try {
                return block()
            } catch (e: Exception) {
                Timber.e(e)
            }
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtLeast(maxDelayMillis)
        }

        return block()
    }


    private suspend fun loadRecentAndroidVersion() {
        val recentAndroidVersions = api.getRecentAndroidVersions()
        uiState.value = UiState.Success(recentAndroidVersions)
    }

}