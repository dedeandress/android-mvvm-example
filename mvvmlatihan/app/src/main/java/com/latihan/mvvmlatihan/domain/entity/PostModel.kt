package com.latihan.mvvmlatihan.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostModel(
    val userId: Int,
    @PrimaryKey
    val id: Int,
    val title: String,
    val body: String)