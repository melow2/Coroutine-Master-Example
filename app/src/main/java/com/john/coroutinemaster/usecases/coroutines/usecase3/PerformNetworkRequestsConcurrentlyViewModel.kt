package com.john.coroutinemaster.usecases.coroutines.usecase3

import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi

class PerformNetworkRequestsConcurrentlyViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequestsSequentially() {

    }

    fun performNetworkRequestsConcurrently() {

    }
}