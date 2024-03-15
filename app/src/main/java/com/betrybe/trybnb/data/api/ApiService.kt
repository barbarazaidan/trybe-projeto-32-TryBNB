package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.ReservationApiIds
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // https://restful-booker.herokuapp.com/
    @POST("auth")
    suspend fun postLoginAuthentication(@Body requestBody: LoginRequest): Response<LoginResponse>

    @GET("booking")
    suspend fun getBookingList(): Response<List<ReservationApiIds>>

//    @GET("booking/{id}")
//    suspend fun getBookingList(@Path("id") id: Int): Response<>
}