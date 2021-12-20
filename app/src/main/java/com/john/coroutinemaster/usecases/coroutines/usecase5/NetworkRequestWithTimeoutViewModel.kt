package com.john.coroutinemaster.usecases.coroutines.usecase5

import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi

class NetworkRequestWithTimeoutViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest(timeout: Long) {

    }

}