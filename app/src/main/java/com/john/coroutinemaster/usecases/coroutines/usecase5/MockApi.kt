package com.john.coroutinemaster.usecases.coroutines.usecase5

import com.google.gson.Gson
import com.john.coroutinemaster.mock.createMockApi
import com.john.coroutinemaster.mock.mockAndroidVersions
import com.john.coroutinemaster.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            Gson().toJson(mockAndroidVersions),
            200,
            1000
        )
)