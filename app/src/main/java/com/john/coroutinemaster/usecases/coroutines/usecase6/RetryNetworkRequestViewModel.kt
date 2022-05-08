package com.john.coroutinemaster.usecases.coroutines.usecase6

import androidx.lifecycle.viewModelScope
import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi
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
            repeat(numberOfRetries){
                try {
                    loadRecentAndroidVersion()
                    return@launch
                }catch (e:Exception){
                    Timber.e(e)
                    uiState.value = UiState.Error("Network request failed!")
                }
            }
        }
    }

    private suspend fun loadRecentAndroidVersion(){
        val recentAndroidVersions = api.getRecentAndroidVersions()
        uiState.value = UiState.Success(recentAndroidVersions)
    }

}