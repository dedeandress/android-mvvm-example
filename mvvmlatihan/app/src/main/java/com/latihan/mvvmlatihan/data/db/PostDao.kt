package com.latihan.mvvmlatihan.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.latihan.mvvmlatihan.domain.entity.PostModel
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PostDao{

    @get:Query("SELECT * from post")
    val all: Observable<List<PostModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: PostModel)

}