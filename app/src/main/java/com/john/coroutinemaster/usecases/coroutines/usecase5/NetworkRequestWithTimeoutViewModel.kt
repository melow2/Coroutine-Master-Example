package com.john.coroutinemaster.usecases.coroutines.usecase5

import androidx.lifecycle.viewModelScope
import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import timber.log.Timber
import java.lang.Exception

class NetworkRequestWithTimeoutViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest(timeout: Long) {
        uiState.value = UiState.Loading
        usingWithTimeOutOrNull(timeout)

    }

    private fun usingWithTimeOutOrNull(timeOut: Long) {
        viewModelScope.launch {
            try {
                val recentAndroidVersions = withTimeoutOrNull(timeOut) {
                    api.getRecentAndroidVersions()
                }
                if(recentAndroidVersions != null){
                    uiState.value = UiState.Success(recentAndroidVersions)
                } else {
                    uiState.value = UiState.Error("Network request timed out!")
                }
            } catch (e: Exception) {
                Timber.e(e)
                uiState.value = UiState.Error("Network request failed!")
            }
        }
    }

}