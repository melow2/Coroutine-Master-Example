package com.john.coroutinemaster.playground.fundermentals


// android not responding : 앱이 반응이 없다
// 안드로이드에서 앱이 멈춘다
/*
 * 코루틴이란? 코 + 루틴  CO+Routine
 * routine이란?
 *
 * 1. routines
 * 특정 작업을 수행해야 하는 일련의 프로그램의 지침.
 * 작업이 있는 코드
 * 동기화가 되면 좋은데 작업시간이 너무 길어짐 (작업시간 n1 + n2 + n3 ...)
 * 그러므로 동시에 작업을 수행하자
 * cooperate + routine = Coroutine
 * 같이 실행한다는 거 자체가 동기화의 개념이 꺠진다.
 * 동기화의 개념 반대인 비동기화
 * 비동기 -> 여러개의 작업을 동시에 수행할 수 있다.
 * 비동기로 작업이 필요한 프로그램
 * 그 프로그램을 개발하는 것이 비동기 프로그래밍
 * 비동기프로그래밍(Asynchronous Programing)을 코루틴으로 구현할 수 있다.
 * 코루틴은 비동기프로그래밍을 가능하게 해주는 안드로이드 기술
 *
 *

 */

fun main() {
    println("main thread start")
    routine(1,500)
    routine(2,300)
    println("main thread ends")

}

/*
 * Routine
 *
 * @param number 작업번호
 * @param delay 작업을 수행하는데 걸리는 시간
 */

fun routine(number:Int, delay :Long){
    println("Routine $number Starts work")
    Thread.sleep(delay) // 스레드가 딜레이 된 만큼 멈춤 -> delay가 작업을하는데 걸리는 시간
    println("Routine $number has finished")

}

//