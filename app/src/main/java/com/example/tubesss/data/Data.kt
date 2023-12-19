package com.example.tubesss.data

import com.google.gson.annotations.SerializedName

data class Data(
    val id: Int,
    val user_id: Int,
    val title: String,
    val description: String,
    val status: String,
    val deadline: String,
)