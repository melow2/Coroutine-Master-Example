package com.john.coroutinemaster.playground.colutinebuilder

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    val startTime = System.currentTimeMillis()

    val deffered1 = async {
        val result= networkCall(1)
        println("result received: $result after ${elapsedMillis(startTime)}ms")
        result
    }
    val deffered2 = async {
        val result = networkCall(2)
        println("result received: $result after ${elapsedMillis(startTime)}ms")
        result
    }



    val resultList = listOf(deffered1.await(),deffered2.await())

    println("Result list : $resultList after ${elapsedMillis(startTime)}ms")

}




suspend fun networkCall(number:Int):String{
    delay(500)
    return "Result ## $number"
}

//최종걸린 걸린시간
fun elapsedMillis(startTime:Long)=System.currentTimeMillis() - startTime

//시작시간 - 현재시간


//작업의 결과값들을 제대로 보장해줌