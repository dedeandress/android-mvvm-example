package com.latihan.mvvmlatihan.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.latihan.mvvmlatihan.domain.entity.PostModel

@Dao
interface PostDao{

    @get:Query("SELECT * from post")
    val all: List<PostModel>

    @Insert
    fun insert(post: PostModel)

}