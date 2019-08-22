package com.latihan.mvvmlatihan.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.latihan.mvvmlatihan.AppController
import com.latihan.mvvmlatihan.ui.favorite.FavoriteViewModel
import com.latihan.mvvmlatihan.ui.post.PostListViewModel

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
            is FavoriteViewModel -> {
                (getApplication() as AppController).getViewModelInjector().inject(this)
            }
        }
    }


}