package com.john.coroutinemaster.playground.structuredconcurrency

import kotlinx.coroutines.*


// Every Coroutines needs to be started in a logical scope with a limited life-time
// 모든 코루틴은 수명주기가 있는 논리적 스콥에서 시작해야 한다.

val scope = CoroutineScope(Dispatchers.Default)

fun main() = runBlocking {
    val job = scope.launch {
        delay(100)
        println("Coroutine completed.")
    }
    job.invokeOnCompletion {
        if(it is CancellationException){
            println("Coroutine was cancelled!")
        }
    }
    delay(50)
    onDestroy()
}

fun onDestroy() {
    println("life-time of scope ends")
    scope.cancel()
}