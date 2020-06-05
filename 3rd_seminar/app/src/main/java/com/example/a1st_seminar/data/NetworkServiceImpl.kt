package com.example.a1st_seminar.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkServiceImpl {
    private const val BASE_URL = "http://13.209.144.115:3002/"

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val SERVICE: NetworkService = retrofit.create(
        NetworkService::class.java
    )
}