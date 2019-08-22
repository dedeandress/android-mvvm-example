package com.latihan.mvvmlatihan.ui

import android.app.Application
import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.base.BaseViewModel
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.usecase.PostUsecase
import com.latihan.mvvmlatihan.utils.Resource
import javax.inject.Inject

class PostListViewModel(app: Application) : BaseViewModel(app) {

    @Inject
    lateinit var postUsecase: PostUsecase

    fun getPost(): LiveData<List<PostModel>>{
        return postUsecase.getPost()
    }

    fun getProgressBarVisibility(): LiveData<Int>{
        return postUsecase.getProgressVisibility()
    }


    fun getResource(): LiveData<Resource<List<PostModel>>>{
        return postUsecase.getResource()
    }
}
