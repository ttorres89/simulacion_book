package com.example.anchor_book.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.anchor_book.data.model.Book
import com.example.anchor_book.data.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val repository = BookRepository()
    val books= repository.getBooks().asLiveData()
    var  book:Book? = null


    fun buscarLibro(id:Int){
        viewModelScope.launch {
            book=  repository.getOnBooks(id)
        }
    }


}