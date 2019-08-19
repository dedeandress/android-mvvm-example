package com.latihan.mvvmlatihan.domain.repository

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel

interface PostRepository {

    fun getPostList(): LiveData<List<PostModel>>

    fun loadPost()
}