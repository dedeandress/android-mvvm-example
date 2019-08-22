package com.latihan.mvvmlatihan.di

import com.latihan.mvvmlatihan.AppController
import dagger.Component

@Component(
    modules = [(AppModule::class)]
)
interface AppComponent {

    fun inject(appController: AppController)

}