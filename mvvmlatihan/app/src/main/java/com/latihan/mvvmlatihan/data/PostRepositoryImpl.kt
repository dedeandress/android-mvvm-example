package com.latihan.mvvmlatihan.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.mvvmlatihan.data.source.DataSource
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val dataSource: DataSource) : PostRepository {
    private lateinit var subscription: Disposable

    private var postLiveData = MutableLiveData<List<PostModel>>()

    override fun getPostList(): LiveData<List<PostModel>> {
        return postLiveData
    }

    override fun loadPost(){
        subscription =  dataSource.getPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    postLiveData.value = it
                },
                {
                    Log.e("PostRepository", "Cannot Reach API")
                }
            )
    }
}