package com.john.coroutinemaster.playground.fundermentals

import kotlin.concurrent.thread


// Out Of Memory == OOM (메모리부족)
// 같은 양을 수행해도 코루틴은 실행이 되는데 스레드는 실행이 안됨
// 스레드 생성 시 oom이 뜸 굉장히 많은 리소스를 차지함
fun main() {
    repeat(5){
        thread{
            Thread.sleep(5000)
            println("*")
        }
    }
}