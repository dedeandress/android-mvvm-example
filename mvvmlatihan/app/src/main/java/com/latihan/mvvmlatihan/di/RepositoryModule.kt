package com.latihan.mvvmlatihan.di

import com.latihan.mvvmlatihan.data.PostApi
import com.latihan.mvvmlatihan.data.PostRepositoryImpl
import com.latihan.mvvmlatihan.data.db.AppDatabase
import com.latihan.mvvmlatihan.data.db.PostDao
import com.latihan.mvvmlatihan.data.source.DataSource
import com.latihan.mvvmlatihan.data.source.DataSourceImpl
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import com.latihan.mvvmlatihan.domain.usecase.PostUsecase
import dagger.Module
import dagger.Provides

@Module
@Suppress("unused")
object RepositoryModule {

    @Provides
    fun providePostRepository(dataSource: DataSource, postDao: PostDao): PostRepository{
        return PostRepositoryImpl(dataSource, postDao)
    }

    @Provides
    fun provideDataSource(postApi: PostApi): DataSource{
        return DataSourceImpl(postApi)
    }

    @Provides
    fun providePostUseCase(postRepository: PostRepository): PostUsecase{
        return PostUsecase(postRepository)
    }

}