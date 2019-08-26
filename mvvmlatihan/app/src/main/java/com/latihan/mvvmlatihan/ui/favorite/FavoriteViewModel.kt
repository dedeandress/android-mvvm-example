package com.latihan.mvvmlatihan.ui.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import com.latihan.mvvmlatihan.base.BaseViewModel
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.usecase.PostUsecase
import javax.inject.Inject

class FavoriteViewModel(application: Application) : BaseViewModel(application) {

    @Inject
    lateinit var postUsecase: PostUsecase

    fun favoritePost(): LiveData<List<PostModel>> {
        return postUsecase.favoritePost()
    }

    fun deletePost(postModel: PostModel) {
        return postUsecase.deletePost(postModel)
    }
}
