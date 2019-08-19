package com.latihan.mvvmlatihan.ui

import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.base.BaseViewModel
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.usecase.PostUsecase
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    @Inject
    lateinit var postUsecase: PostUsecase

    fun getPost(): LiveData<List<PostModel>>{
        return postUsecase.getPost()
    }

}
