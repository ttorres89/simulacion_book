package com.example.anchor_book.data.network.core

import com.example.anchor_book.data.model.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("Himuravidal/anchorBooks/books")
    suspend fun getAllBook(): Response<List<Book>>

    @GET("Himuravidal/anchorBooks/bookDetail/{id}")
    suspend fun getBook(@Path("id")  id:Int): Response<Book>

}