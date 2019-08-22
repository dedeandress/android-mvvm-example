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
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

const val TAG = "PostRepository"

class PostRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
    private val postDao: PostDao
) : PostRepository {
    private lateinit var subscription: Disposable

    private var subs = CompositeDisposable()

    private var resource = MutableLiveData<Resource<List<PostModel>>>()

    private var favoritePost = MutableLiveData<List<PostModel>>()

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

    override fun insertPost(post: PostModel) {
       subs.addAll(Observable.fromCallable { postDao.insert(post) }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe()
       )
    }

    override fun getFavoritePost(): LiveData<List<PostModel>> {
        subscription = postDao.all
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    favoritePost.value = it
                },
                {
                    Log.e(TAG, "cannot get post from db")
                }
            )

        return favoritePost
    }
}