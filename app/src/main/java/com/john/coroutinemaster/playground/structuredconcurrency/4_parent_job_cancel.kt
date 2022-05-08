package com.john.coroutinemaster.playground.structuredconcurrency

import kotlinx.coroutines.*

// Canceling a parent will cancel all children. canceling a child won't cancel the parent or siblings.
// 부모를 취소시키면 자식까지 다 취소시키고, 자식은 안된다.

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    scope.coroutineContext[Job]!!.invokeOnCompletion {
        if(it is CancellationException){
            println("Parent was cancelled")
        }
    }

    val children = scope.launch {
        delay(1000)
        println("Coroutine 1 completed")
    }

    children.invokeOnCompletion { throwable ->
        if( throwable is CancellationException){
            println("Coroutine 1 was cancelled")
        }
    }

    scope.launch {
        delay(1000)
        println("Coroutine 2 completed")
    }.invokeOnCompletion { throwable ->
        if( throwable is CancellationException){
            println("Coroutine 2 was cancelled")
        }
    }

    delay(200)
    children.cancelAndJoin()
//    scope.coroutineContext[Job]!!.cancelAndJoin()
}