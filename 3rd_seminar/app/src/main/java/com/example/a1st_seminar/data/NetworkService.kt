package com.example.a1st_seminar.data

import com.example.a1st_seminar.data.model.SignInResponse
import com.example.a1st_seminar.data.model.SignUpResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {
    @POST("/user/signup")
    fun postSignUp(
        @Body body: JsonObject
    ): Call<SignUpResponse>

    @POST("/user/signin")
    fun postSignIn(
        @Body body: JsonObject
    ): Call<SignInResponse>
}