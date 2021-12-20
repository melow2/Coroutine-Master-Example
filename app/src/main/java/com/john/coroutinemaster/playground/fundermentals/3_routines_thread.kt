package com.john.coroutinemaster.playground.fundermentals

import kotlin.concurrent.thread

fun main() {
    println("main thread start.")
    threadRoutine(1,500)
    threadRoutine(2,300)
    Thread.sleep(1000)
    println("main thread end.")
}

fun threadRoutine(number:Int, delay:Long){
    //새로운 스레드를 생성
    thread {
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("Routine $number has finished")
    }

}