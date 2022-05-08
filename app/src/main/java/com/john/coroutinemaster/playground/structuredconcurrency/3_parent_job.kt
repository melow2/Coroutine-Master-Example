package com.john.coroutinemaster.playground.structuredconcurrency

import kotlinx.coroutines.*


// A parent job won't complete, until all of its children have completed.
// 부모의 job은 자식의 job이 완료될떄까지 cancel하지 않는다.

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    val parentCoroutineJob = scope.launch {
        launch {
            delay(1000)
            println("Child Coroutine 1 has complted")
        }

        launch {
            delay(1000)
            println("Child Coroutine 2 has complted")
        }
    }
    parentCoroutineJob.join()
    println("Parent coroutine has completed")
}