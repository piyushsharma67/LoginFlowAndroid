package com.example.loginflow.features.authentication.api


import retrofit2.Response
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("/signup")
    suspend fun signup():Response<String>

    @POST("login")
    suspend fun login():Response<String>

}