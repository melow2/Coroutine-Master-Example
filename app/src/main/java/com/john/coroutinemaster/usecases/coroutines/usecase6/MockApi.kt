package com.john.coroutinemaster.usecases.coroutines.usecase6

import com.google.gson.Gson
import com.john.coroutinemaster.mock.createMockApi
import com.john.coroutinemaster.mock.mockAndroidVersions
import com.john.coroutinemaster.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            "something went wrong on server side",
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            "something went wrong on server side",
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            Gson().toJson(mockAndroidVersions),
            200,
            1000
        )
)