package com.latihan.mvvmlatihan.di

import com.latihan.mvvmlatihan.AppController
import com.latihan.mvvmlatihan.ui.favorite.FavoriteViewModel
import com.latihan.mvvmlatihan.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(NetworkModule::class), (RepositoryModule::class), (RoomModule::class)]
)
interface ViewModelInjector{

    fun inject(viewModel: PostListViewModel)
    fun inject(viewModel: FavoriteViewModel)
    fun inject(viewModel: AppController)

    @Component.Builder
    interface Builder{
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun roomModule(roomModule: RoomModule): Builder
    }

}