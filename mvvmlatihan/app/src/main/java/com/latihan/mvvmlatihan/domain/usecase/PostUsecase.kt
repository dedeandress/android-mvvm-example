package com.latihan.mvvmlatihan.domain.usecase

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import com.latihan.mvvmlatihan.utils.Resource
import javax.inject.Inject

class PostUsecase @Inject constructor(private val repository: PostRepository) {

    fun getPost(): LiveData<List<PostModel>>{
        initPost()
        return repository.getPostList()
    }

    fun getProgressVisibility(): LiveData<Int>{
        return repository.getProgressVisibility()
    }

    private fun initPost(){
        repository.loadPost()
    }

    fun getResource(): LiveData<Resource<List<PostModel>>> {
        initPost()
        return repository.getResource()
    }

}