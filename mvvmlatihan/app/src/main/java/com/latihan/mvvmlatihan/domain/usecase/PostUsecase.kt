package com.latihan.mvvmlatihan.domain.usecase

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import javax.inject.Inject

class PostUsecase @Inject constructor(private val repository: PostRepository) {

    fun getPost(): LiveData<List<PostModel>>{
        initPost()
        return repository.getPostList()
    }

    private fun initPost(){
        repository.loadPost()
    }

}