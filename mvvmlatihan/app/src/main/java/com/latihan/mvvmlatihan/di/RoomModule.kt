package com.latihan.mvvmlatihan.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.latihan.mvvmlatihan.data.db.AppDatabase
import com.latihan.mvvmlatihan.data.db.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "latihan-database").build()
    }

    @Provides
    fun providePostDao(appDatabase: AppDatabase): PostDao {
        return appDatabase.postDao()
    }


}