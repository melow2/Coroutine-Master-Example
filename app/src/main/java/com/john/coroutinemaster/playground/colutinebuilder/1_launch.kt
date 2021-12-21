package com.john.coroutinemaster.playground.colutinebuilder

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Coroutine Builders
 *
 * 1. CoroutineScope를 생성하는 레퍼런스.
 * -async :
 *      기본값은 무조건 실행
 *      LAZY가 걸려있으면 job.start()시점에 코루틴 블럭이 실행
 *      await()은 실행순서를 보장해줌 -> 다음줄에 변수 지정 시 결과값을 받을 수 있다
 *      Coroutine Scope의 결과값을 받을 수 있다.
 *      여러가지 서스펜드 펑션을 실행하고, 조합한 결과값을 받고, 실행순서까지 보장해줌
 *
 *      여러가지 비동기 과정이 있을 때 결과값을 받을 때
 *
 * -runBlocking : 코루틴이 실행 중인 스레드를 멈추게 하기(Blocking) 때문이다
 *
 * -launch :
 *      기본값은 무조건 실행
 *      LAZY가 걸려있으면 job.start()시점에 코루틴 블럭 이 실행
 * 이 세가지만으로도 앱을 개발하는데 문제가 전혀 없다.
 * 대신 runBlocking은 쓰지마라
 * 그럼 남는게 async launch다.
 *
 * 스레드 세이프티 -> 코루틴은 실행중인 스레드를 멈추게 하지 않는다

 */


fun main()= runBlocking {

    val job = launch{
        val result = networkRequest()
        println("Result received ::$result")
    }


    job.start()
    println("end of runBlocking")
}

suspend fun networkRequest():String{
    delay(500)//회원목록을 받아옴
    return "회원목록"
}

//스콥 안에 스콥이 있기 때문에 안쪽 스콥이 더 늦게 실행이 됨