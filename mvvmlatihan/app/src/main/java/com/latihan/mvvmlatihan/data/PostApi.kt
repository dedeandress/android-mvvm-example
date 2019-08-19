package com.latihan.mvvmlatihan.data

import com.latihan.mvvmlatihan.domain.entity.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPost(): Observable<List<PostModel>>

}