package com.john.coroutinemaster.usecases.coroutines.usecase2

import com.google.gson.Gson
import com.john.coroutinemaster.mock.createMockApi
import com.john.coroutinemaster.mock.mockAndroidVersions
import com.john.coroutinemaster.mock.mockVersionFeaturesAndroid10
import com.john.coroutinemaster.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            Gson().toJson(mockAndroidVersions),
            200,
            1500
        )
        .mock(
            "http://localhost/android-version-features/29",
            Gson().toJson(mockVersionFeaturesAndroid10),
            200,
            1500
        )
)