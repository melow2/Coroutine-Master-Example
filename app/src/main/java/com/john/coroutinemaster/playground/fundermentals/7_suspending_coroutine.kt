package com.john.coroutinemaster.playground.fundermentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("main thread starts")
    joinAll(
        async {
              suspendingCoroutine(1,500)
        },
        async { suspendingCoroutine(2,300) },
        async { repeat(5){
            println("other tasks is working on ${Thread.currentThread().name}")
            delay(100)
        } }
    )
    println("main thread end.")

}

suspend fun suspendingCoroutine(number:Int, delay:Long){
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name}")
}

//코루틴이 실행되는동안 스레드를 블로킹 하지 않음
//스콥안에 코루틴 동기화되아있다,.