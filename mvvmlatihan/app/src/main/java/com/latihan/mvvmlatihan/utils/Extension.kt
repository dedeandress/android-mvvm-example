package com.latihan.mvvmlatihan.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T): MutableLiveData<Resource<T>> {

    value =  Resource(ResourceState.SUCCESS, data)

    return this
}

fun <T> MutableLiveData<Resource<T>>.setSuccess(): MutableLiveData<Resource<T>> {

    value = Resource(ResourceState.SUCCESS, null)

    return this
}

fun <T> MutableLiveData<Resource<T>>.setLoading(): MutableLiveData<Resource<T>> {

    value = Resource(ResourceState.LOADING, value?.data)

    return this
}


fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable? = null): MutableLiveData<Resource<T>> {

    value = Resource(ResourceState.ERROR, value?.data, throwable)

    return this
}
