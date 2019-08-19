package com.latihan.mvvmlatihan.di

import com.latihan.mvvmlatihan.ui.PostListViewModel
import dagger.Component

@Component(
    modules = [(NetworkModule::class), (RepositoryModule::class)]
)
interface ViewModelInjector{

    fun inject(viewModel: PostListViewModel)

    @Component.Builder
    interface Builder{
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }

}