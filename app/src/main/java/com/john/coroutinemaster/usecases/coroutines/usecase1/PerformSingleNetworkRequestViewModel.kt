package com.john.coroutinemaster.usecases.coroutines.usecase1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.john.coroutinemaster.base.BaseViewModel
import com.john.coroutinemaster.mock.MockApi
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class PerformSingleNetworkRequestViewModel(

    //도메인레이어의 usecase
    private val mockApi: MockApi = mockApi()
) : ViewModel() {

    val uiState:MutableLiveData<UiState> = MutableLiveData()

    fun performSingleNetworkRequest() {
        //1. 로딩상태
        uiState.value = UiState.Loading
        //코루틴은 현재 자기가 실행중인 스레드를 블럭킹하지 않는다
        //main thread safety 스레드가 안정하다. 스레드의 안정성을 보장해준다.


        //viewModelScope안에 실행중인 여러가지 코루틴이 있는데
        // 그 코루틴들이 뷰모델이 없어질때 (destroy)될 때 같이 취소가 됨
        //그러니까 코루틴의 라이프사이클이 뷰모델의 라이프사이클을 따라갈 수 있도록 만든 아주 특별한 코루틴 스콥
        //일반적으로 코루틴들을 취소하지 않으면 코루틴은 삭제되지 않음(메모리가 남아있음)
        //하지만 뷰모델 스콥 안에 선언된 ㅅ코루틴들은 따로 취소를 해주지 않아도 뷰모델이 삭제될 때 알아서 메모리에서 지워진다.
        viewModelScope.launch {

            try {
                //서버에서 데이터를 요청
                val recentAndroidVersion=mockApi.getRecentAndroidVersions()

                if (recentAndroidVersion.size<100){
                    throw java.lang.Exception()
                }
                //뷰로 데이터 전송
                uiState.value = UiState.Success(recentAndroidVersion)
            } catch (e:Exception){
                //에러가 발생했을 경우 데이터 요청에 실패했을 경우
                uiState.value = UiState.Error("에러가 발생했어요 ㅜㅜ")
            }

        }
        Timber.tag("LogTest").d("테스트로그입니다~~")
    }
}