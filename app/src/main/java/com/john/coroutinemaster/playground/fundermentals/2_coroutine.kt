package com.john.coroutinemaster.playground.fundermentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

/*
 *1. suspend
 * - 일시중단하다
 * 코루틴을 사용할 때는 항상 suspend키워드를 붙여야 함.
 * 함수 앞에 붙인다 무조건 쓰여짐
 *
 * suspend가 붙으면 이 함수는 중단이 될 수 있는 함수
 * 그러고 중단이 되어었다가 다시 실행 될 수 있는 함수
 *
 * 2. Suspend vs Blocking
 * -suspend 일시중단
 * -blocking 멈춤
 * suspend는 suspend되더라도 다른 작업들이 수행되지만
 * blocking은 아얘 다음줄의 작업으로 넘어갈 수 없다
 *
 * ex) 루틴에서 스레드블록된것
 *
 *
 */


fun main()= runBlocking {
    //전체가 메인스레드 안에서 동작함
    //하나의 스레드에 하나의 코루틴 스콥에 여러개의 코루틴이 돔
    //코루틴을 Light weight thread라고 부른다 그치만 스레드는 아님
    //이 코루틴 스콥을 실행할 때 스레드는 멈춘다는 뜻
    //코루틴 스콥이 끝나야 스레드가 풀림
    //runBlocking이 끝나야지만 다음칸으로 넘어감
    //메인 스레드를 자체를 멈추게 하므로 쓰면 안됨



    //이 안에서 코루틴 작업을 수행 할 수 있음 그 공간이 코루틴 스콥임
    //코루틴은 프로그래밍 기술이라고 생각하면 됨

    println("main thread start")
    val job1 = async { coroutine(1, 500) }
    val job2 = async { coroutine(2,300) }
    //async 메인 스레드를 멈추게 하지 않음
    //안에 있는게 안끝나도 다음작업으로 쭉쭉 넘어감
    //코드는 따로 써져있어도 동시에 실행이 되어 1번이 늦게 끝남
    joinAll(job1, job2)
    println("main thread end")



}

suspend fun coroutine(number:Int, delay:Long){
    println("Coroutine $number starts work")
    delay(delay)
    println("Coroutine $number has finished")
}

/*
 * 3. 정리
 * 코루틴은 일시 중단 될 수 있는 특별한 함수
 * 코루틴은 suspend function으로 실행이 된다.
 * suspend function은 suspend point(화살표)에 멈춘다
 * suspend point가 있는 부분이 코루틴이 실행된다
 */