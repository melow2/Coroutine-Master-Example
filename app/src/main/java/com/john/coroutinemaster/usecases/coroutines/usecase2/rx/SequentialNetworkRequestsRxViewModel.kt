package com.john.coroutinemaster.usecases.coroutines.usecase2.rx

import com.john.coroutinemaster.base.BaseViewModel

class SequentialNetworkRequestsRxViewModel(
    private val mockApi: RxMockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun perform2SequentialNetworkRequest() {

    }
}