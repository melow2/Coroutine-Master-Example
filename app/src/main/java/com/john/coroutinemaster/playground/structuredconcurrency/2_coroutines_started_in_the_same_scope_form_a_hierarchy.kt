package com.john.coroutinemaster.playground.structuredconcurrency

import kotlinx.coroutines.*

// Coroutines started in the same scope form a hierarchy.
// 동일한 스코프에서 시작된 코루틴은 계층을 형성한다.

fun main(){
    val scopeJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + scopeJob)

    var childCoroutineJob:Job? = null
    val passedJob = Job()
    val coroutineJob = scope.launch(passedJob) {
        childCoroutineJob = launch {
            println("Starting Child coroutine")
            delay(100)
        }
        println("Starting coroutine")
        delay(100)
    }

    Thread.sleep(1000)

    println("passedJob and coroutineJob are references to the same job object => " +
            "${passedJob == coroutineJob}")

    println("Is childCoroutineJob a child of coroutineJob? =>" +
            " ${coroutineJob.children.contains(childCoroutineJob)}")

    println("Is coroutineJob a child of scopeJob? =>" +
            " ${scopeJob.children.contains(coroutineJob)}")

}