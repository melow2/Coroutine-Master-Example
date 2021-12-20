package com.john.coroutinemaster.usecases.coroutines.usecase1

import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi

class PerformSingleNetworkRequestViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performSingleNetworkRequest() {

    }
}