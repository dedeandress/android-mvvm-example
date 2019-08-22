package com.latihan.mvvmlatihan.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.latihan.mvvmlatihan.domain.entity.PostModel

@Database(entities = [PostModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao

}