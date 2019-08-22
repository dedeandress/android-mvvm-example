package com.latihan.mvvmlatihan.domain.repository

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.utils.Resource

interface PostRepository {

    fun loadPost()

    fun getResource(): LiveData<Resource<List<PostModel>>>

    fun insertPost(post: PostModel)

    fun getFavoritePost(): LiveData<List<PostModel>>
}