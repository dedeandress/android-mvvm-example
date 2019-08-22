package com.latihan.mvvmlatihan.domain.repository

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.utils.Resource

interface PostRepository {

    fun getPostList(): LiveData<List<PostModel>>

    fun loadPost()

    fun getProgressVisibility(): LiveData<Int>

    fun getResource(): LiveData<Resource<List<PostModel>>>
}