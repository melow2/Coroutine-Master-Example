package com.john.coroutinemaster.usecases.coroutines.usecase2.callbacks

import com.john.coroutinemaster.base.BaseViewModel

class SequentialNetworkRequestsCallbacksViewModel(
    private val mockApi: CallbackMockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun perform2SequentialNetworkRequest() {

    }
}