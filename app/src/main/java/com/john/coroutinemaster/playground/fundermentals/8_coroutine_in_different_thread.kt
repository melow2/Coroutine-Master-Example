package com.john.coroutinemaster.playground.fundermentals

import kotlinx.coroutines.*

fun main()= runBlocking {
    println("main thread starts")
    joinAll(
        async { threadSwitchingCoroutine(1,500) },
        async { threadSwitchingCoroutine(2,300) }
    )
    println("main thread ends")
}

suspend fun threadSwitchingCoroutine(number: Int, delay:Long){
    println("Coroutine $number starts works on ${Thread.currentThread().name}")
    delay(delay)
    //메인스레드
    withContext(Dispatchers.IO){
        println("Coroutine $number has finished on ${Thread.currentThread().name}")
           //io스레드
        //todo 컨텍스트 스위칭 비용이 큰 건 어떻게 알아?
    }
}//메인스레드

//프로그래밍이 실행될 시 context는 스레드를 뜻함

//코루틴에서도 스레드를 스위칭해야하는데 그게 위드컨텍스트라는 코루틴 api다
//그때 위드컨텍스트 아이오 메인 이런걸 쓸수있는데
//아이오를 적었을때 그 스콥안에 적힌 코드들은 아이오스레드로 간다
//스레드간 컨텍스트 스위칭을 코루틴 안에서도 할수가 있다.