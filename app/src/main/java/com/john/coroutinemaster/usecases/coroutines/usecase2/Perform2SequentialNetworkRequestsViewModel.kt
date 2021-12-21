package com.john.coroutinemaster.usecases.coroutines.usecase2

import androidx.lifecycle.viewModelScope
import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi
import kotlinx.coroutines.launch
import java.lang.Exception

class Perform2SequentialNetworkRequestsViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun perform2SequentialNetworkRequest() {
        uiState.value=UiState.Loading
        viewModelScope.launch {
            try {
                val recentVersion = mockApi.getRecentAndroidVersions()
                //최신 안드로이드 버전
                val mostRecentVersion = recentVersion.last()
                //

                val featuresOfMostRecentVersion =
                    mockApi.getAndroidVersionFeatures(mostRecentVersion.apiLevel)
                uiState.value = UiState.Success(featuresOfMostRecentVersion)
            }catch (e:Exception){
                uiState.value = UiState.Error(e.localizedMessage)
            }
        }

    }
}