package com.example.anchor_book.data.repository

import android.util.Log
import com.example.anchor_book.data.db.config.Anchor_book_app.Companion.db
import com.example.anchor_book.data.db.entities.BookEntity
import com.example.anchor_book.data.model.Book
import com.example.anchor_book.data.network.BookService
import com.example.anchor_book.data.repository.dataConversor.BooksConversor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class BookRepository {

    private val bookService = BookService()

    fun getBooks(): Flow<List<Book>> = flow{


        val booksResponse = kotlin.runCatching { bookService.getBooks() }

        booksResponse.onSuccess {
            if(it.body()!=null)
            {
                Log.d("Json", it.body().toString())
                db.bookDao().insertBook(BooksConversor.convertBookEntity(it.body()!!))

            }
        }

        booksResponse.onFailure {
            Log.d("Error", it.toString())

        }

        val listaBooksEntity:List<BookEntity> =  db.bookDao().getAll()

        if(listaBooksEntity!=null){
            emit(BooksConversor.convertBook(listaBooksEntity))
        }


    }.flowOn(Dispatchers.IO)

    suspend fun getOnBooks(id:Int): Book? {


        val booksResponse = kotlin.runCatching { bookService.getOneBook(id) }
        //val book = Book(id)

        booksResponse.onSuccess {
            if(it.body()!=null)
            {
                Log.d("Json_unique_book", it.body().toString())
                db.bookDao().insertOneBook(BooksConversor.convertOneBookEntity(it.body()!!))

            }
        }

        booksResponse.onFailure {
            Log.d("Error_unique_book", it.toString())

        }

        val BooksEntity:BookEntity =  db.bookDao().getOneBook(id)

        if(BooksEntity!=null){
            return BooksConversor.convertOneBook(BooksEntity)
        }

        return null
    }



}