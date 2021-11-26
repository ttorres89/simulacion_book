package com.example.anchor_book.ui.viewmodel

import androidx.lifecycle.*
import com.example.anchor_book.data.db.config.Anchor_book_app.Companion.prefs
import com.example.anchor_book.data.model.Book
import com.example.anchor_book.data.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val repository = BookRepository()

    val books= repository.getBooks().asLiveData()


    var detail_book=  repository.getOneBook(prefs.idBook!!).asLiveData()




}