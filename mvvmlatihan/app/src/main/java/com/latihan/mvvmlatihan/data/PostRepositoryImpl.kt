package com.latihan.mvvmlatihan.data

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.latihan.mvvmlatihan.data.db.PostDao
import com.latihan.mvvmlatihan.data.source.DataSource
import com.latihan.mvvmlatihan.domain.entity.PostModel
import com.latihan.mvvmlatihan.domain.repository.PostRepository
import com.latihan.mvvmlatihan.utils.Resource
import com.latihan.mvvmlatihan.utils.setError
import com.latihan.mvvmlatihan.utils.setLoading
import com.latihan.mvvmlatihan.utils.setSuccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
    private val postDao: PostDao
) : PostRepository {
    private lateinit var subscription: Disposable

    private var postLiveData = MutableLiveData<List<PostModel>>()

    private var progressBarVisibility = MutableLiveData<Int>()

    private var resource = MutableLiveData<Resource<List<PostModel>>>()

    override fun getPostList(): LiveData<List<PostModel>> {
        return postLiveData
    }

    override fun loadPost(){
        subscription =  dataSource.getPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                resource.setLoading()
                Log.e("PostRepository", "Loadingg....")
            }
            .doOnTerminate {
                Log.e("PostRepository", "Terminate")
            }
            .subscribe(
                {
                    Log.e("PostRepository", "list : $it")
                    resource.setSuccess(it)
                    postLiveData.value = it
                },
                {
                    resource.setError(it)
                    Log.e("PostRepository", "Cannot Reach API")
                }
            )
    }

    override fun getResource(): LiveData<Resource<List<PostModel>>> {
        return resource
    }

    override fun getProgressVisibility(): LiveData<Int> {
        return progressBarVisibility
    }
}