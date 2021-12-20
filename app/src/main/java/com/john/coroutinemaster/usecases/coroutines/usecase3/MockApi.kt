package com.john.coroutinemaster.usecases.coroutines.usecase3

import com.google.gson.Gson
import com.john.coroutinemaster.mock.createMockApi
import com.john.coroutinemaster.mock.mockVersionFeaturesAndroid10
import com.john.coroutinemaster.mock.mockVersionFeaturesOreo
import com.john.coroutinemaster.mock.mockVersionFeaturesPie
import com.john.coroutinemaster.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/android-version-features/27",
            Gson().toJson(mockVersionFeaturesOreo),
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/28",
            Gson().toJson(mockVersionFeaturesPie),
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/29",
            Gson().toJson(mockVersionFeaturesAndroid10),
            200,
            1000
        )
)