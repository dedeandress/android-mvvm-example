package com.latihan.mvvmlatihan

import android.app.Application
import android.util.Log
import com.latihan.mvvmlatihan.di.*

class AppController : Application() {

    private lateinit var viewModelInjector: ViewModelInjector

    override fun onCreate() {
        super.onCreate()
            viewModelInjector = DaggerViewModelInjector.builder()
                .networkModule(NetworkModule)
                .repositoryModule(RepositoryModule)
                .roomModule(RoomModule(applicationContext))
                .build()


        viewModelInjector.inject(this)
    }

    fun getViewModelInjector() : ViewModelInjector {
        Log.e("AppController","getviewmodelInjector ${viewModelInjector != null}")
        return viewModelInjector
    }

}