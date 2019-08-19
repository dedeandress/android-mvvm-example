package com.latihan.mvvmlatihan.data.source

import com.latihan.mvvmlatihan.data.PostApi
import com.latihan.mvvmlatihan.domain.entity.PostModel
import io.reactivex.Observable
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val postApi: PostApi) : DataSource {

    override fun getPost(): Observable<List<PostModel>> {
        return postApi.getPost()
    }

}