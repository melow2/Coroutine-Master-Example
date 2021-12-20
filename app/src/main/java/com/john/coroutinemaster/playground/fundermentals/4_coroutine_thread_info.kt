package com.john.coroutinemaster.playground.fundermentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("main thread start")
    joinAll(
        async { threadInfoCoroutine(1,500) },
        async { threadInfoCoroutine(2,300) }
    )
    println("main thread ends")
}

suspend fun threadInfoCoroutine(number:Int, delay: Long){
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name}")
    //현재 스레드의 이름을 알려주기 위한 코드
}