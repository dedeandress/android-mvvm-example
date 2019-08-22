package com.latihan.mvvmlatihan.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.latihan.mvvmlatihan.AppController
import com.latihan.mvvmlatihan.di.*
import com.latihan.mvvmlatihan.ui.PostListViewModel

abstract class BaseViewModel(app: Application) : AndroidViewModel(app){

    init {
        Log.e("BaseViewModel","Unit")
        inject()
    }

    private fun inject(){
        when(this){
            is PostListViewModel -> {
                Log.e("BaseViewModel", "postlistviewmodel")
                (getApplication() as AppController).getViewModelInjector().inject(this)
            }
        }
    }


}