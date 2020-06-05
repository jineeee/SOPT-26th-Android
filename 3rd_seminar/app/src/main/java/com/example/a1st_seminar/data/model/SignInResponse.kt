package com.example.a1st_seminar.data.model

import com.google.gson.annotations.SerializedName

data class SignInResponse (
    @SerializedName("status")
    val status:Int,
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String
)