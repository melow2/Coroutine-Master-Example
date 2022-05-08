package com.john.coroutinemaster.playground.structuredconcurrency

import kotlinx.coroutines.*
import java.lang.RuntimeException

// if a child coroutine fails, the exception is propagated upwards and depending on th job type,
// either all siblings are cancelled or not.
// 하위 코루틴이 실패하면 예외가 위로 전파되며 작업 유형에 따라 모든 형제자매가 취소되거나 취소되지 않습니다.

fun main(){

    val exceptionHandler = CoroutineExceptionHandler{ context, throwable ->
        println("Caught exception $throwable")

    }
    val scope = CoroutineScope(SupervisorJob() + exceptionHandler)

    scope.launch {
        println("Coroutine 1 starts")
        delay(50)
        println("Coroutine 1 fails")
        throw RuntimeException()
    }

    scope.launch {
        println("Coroutine 2 starts")
        delay(500)
        println("Coroutine 2 completed")
    }.invokeOnCompletion { throwable ->
        if(throwable is CancellationException){
            println("Coroutine 2 got cancelled!")
        }
    }

    Thread.sleep(1000)

    println("Scope got cancelled: ${!scope.isActive}")

}