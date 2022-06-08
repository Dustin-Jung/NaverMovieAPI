package com.android.aop.part2.navermovieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.android.aop.part2.navermovieapi.adapter.NaverMovieAdapter
import com.android.aop.part2.navermovieapi.base.BaseActivity
import com.android.aop.part2.navermovieapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val naverAdapter =  NaverMovieAdapter()

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initViewModel()

    }

    private fun initView(){
        binding.recyclerView.adapter = naverAdapter
    }

    private fun initViewModel(){
        mainViewModel.mainViewStateLiveData.observe(this){viewState->
            when(viewState){

                is MainViewState.GetNaverList ->{
                    naverAdapter.addAll(viewState.list)
                }

                is MainViewState.Error ->{
                    Toast.makeText(this,viewState.message,Toast.LENGTH_LONG ).show()
                }
            }
        }
    }
}