package com.latihan.mvvmlatihan.utils

data class Resource<out T> constructor(val state: ResourceState, val data: T? = null, val throwable: Throwable? = null )