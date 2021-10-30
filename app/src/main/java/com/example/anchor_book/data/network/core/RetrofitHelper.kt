package com.example.anchor_book.data.network.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}