package com.example.anchor_book.data.network

import com.example.anchor_book.data.model.Book
import com.example.anchor_book.data.network.core.ApiServices
import com.example.anchor_book.data.network.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BookService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBooks(): Response<List<Book>> {
        return withContext(Dispatchers.IO){
            retrofit.create(ApiServices::class.java).getAllBook()
        }
    }
    suspend fun getOneBook(id:Int): Response<Book> {
        return withContext(Dispatchers.IO){
            retrofit.create(ApiServices::class.java).getBook(id.toString())
        }
    }
}