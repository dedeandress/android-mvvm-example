package com.latihan.mvvmlatihan.domain.usecase

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import com.latihan.mvvmlatihan.utils.Resource
import javax.inject.Inject

class PostUsecase @Inject constructor(private val repository: PostRepository) {

    private fun initPost(){
        repository.loadPost()
    }

    fun getResource(): LiveData<Resource<List<PostModel>>> {
        initPost()
        return repository.getResource()
    }

    fun favoritePost(): LiveData<List<PostModel>> {
        return repository.getFavoritePost()
    }

    fun insertPost(postModel: PostModel) {
        repository.insertPost(postModel)
    }

}