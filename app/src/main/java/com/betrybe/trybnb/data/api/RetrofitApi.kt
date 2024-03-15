package com.betrybe.trybnb.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {

    private var retrofit: Retrofit? = null

    fun getInstance(): ApiServiceLogin {

        if(retrofit === null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://restful-booker.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit?.create(ApiServiceLogin::class.java)!!
    }
}