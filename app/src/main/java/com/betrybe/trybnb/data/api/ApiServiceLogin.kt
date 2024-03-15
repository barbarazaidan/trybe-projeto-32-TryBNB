package com.betrybe.trybnb.data.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceLogin {

    // https://restful-booker.herokuapp.com/auth
    @POST("auth")
    suspend fun postLoginAuthentication(@Body requestBody: LoginRequest): Response<LoginResponse>
}