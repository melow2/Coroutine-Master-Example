package com.john.coroutinemaster.usecases.coroutines.usecase14

import com.john.coroutinemaster.mock.AndroidVersion
import com.john.coroutinemaster.mock.MockApi
import kotlinx.coroutines.CoroutineScope

class AndroidVersionRepository(
    private var database: AndroidVersionDao,
    private val scope: CoroutineScope,
    private val api: MockApi = mockApi()
) {

    suspend fun getLocalAndroidVersions(): List<AndroidVersion> {
        return database.getAndroidVersions().mapToUiModelList()
    }

    suspend fun loadAndStoreRemoteAndroidVersions(): List<AndroidVersion> {
        return emptyList()
    }

    fun clearDatabase() {

    }
}