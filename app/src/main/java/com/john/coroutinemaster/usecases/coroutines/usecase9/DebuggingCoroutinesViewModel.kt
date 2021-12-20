package com.john.coroutinemaster.usecases.coroutines.usecase9

import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi

class DebuggingCoroutinesViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performSingleNetworkRequest() {

    }
}