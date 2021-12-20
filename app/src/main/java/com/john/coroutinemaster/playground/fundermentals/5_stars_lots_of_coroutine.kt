package com.john.coroutinemaster.playground.fundermentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    repeat(5){
        launch {
            delay(5000)
            println("*")
        }
    }
}


//코루틴스콥 안에 있는 코루틴들은 동기화 되어있다