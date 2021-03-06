package com.android.aop.part2.navermovieapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.aop.part2.navermovieapi.data.repo.NaverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val naverRepository: NaverRepository): ViewModel() {

    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    init{
        searchAPI()
    }

     private fun searchAPI(){
        naverRepository.search(query = "어벤저스", onSuccess = { list->
            _mainViewStateLiveData.value = MainViewState.GetNaverList(list.items)


        }, onFailure = { errorMessage->
            _mainViewStateLiveData.value = MainViewState.Error(errorMessage)
        })
    }
}