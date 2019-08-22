package com.latihan.mvvmlatihan.ui.post

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

    fun getResource(): LiveData<Resource<List<PostModel>>>{
        return postUsecase.getResource()
    }

    fun insertPost(postModel: PostModel) {
        return postUsecase.insertPost(postModel)
    }
}
