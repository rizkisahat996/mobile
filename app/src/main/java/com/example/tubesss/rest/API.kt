package com.example.tubesss.rest

import com.example.tubesss.data.Data
import com.example.tubesss.data.Tasks
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/")
    fun getTasks():Call<List<Data>>
}