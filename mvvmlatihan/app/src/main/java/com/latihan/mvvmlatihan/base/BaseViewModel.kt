package com.latihan.mvvmlatihan.base

import androidx.lifecycle.ViewModel
import com.latihan.mvvmlatihan.di.DaggerViewModelInjector
import com.latihan.mvvmlatihan.di.NetworkModule
import com.latihan.mvvmlatihan.di.RepositoryModule
import com.latihan.mvvmlatihan.ui.PostListViewModel
import com.latihan.mvvmlatihan.di.ViewModelInjector

abstract class BaseViewModel : ViewModel(){

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .repositoryModule(RepositoryModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this){
            is PostListViewModel -> injector.inject(this)
        }
    }


}