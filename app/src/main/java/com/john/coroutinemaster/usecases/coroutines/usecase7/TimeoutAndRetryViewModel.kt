package com.john.coroutinemaster.usecases.coroutines.usecase7

import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi

class TimeoutAndRetryViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest() {

    }
}