package com.john.coroutinemaster.usecases.coroutines.usecase8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.john.coroutinemaster.mock.MockApi

class ViewModelFactory(private val api: MockApi, private val database: AndroidVersionDao) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MockApi::class.java, AndroidVersionDao::class.java)
            .newInstance(api, database)
    }
}