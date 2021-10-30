package com.example.anchor_book.data.repository.dataConversor

import com.example.anchor_book.data.db.entities.BookEntity
import com.example.anchor_book.data.model.Book

class BooksConversor {

    companion object{
        fun convertBookEntity(book: List<Book>): List<BookEntity> {
            val booksEntity = mutableListOf<BookEntity>()
            book.map {
                booksEntity.add(BookEntity(it.id!!, it.author!!, it.country!!, it.imageLink!!, it.language!!,"", 0, it.title!!,0,0,0,false))
            }
            return booksEntity
        }

        fun convertBook(bookEntity: List<BookEntity>): List<Book> {

            val books= mutableListOf<Book>()

            bookEntity.map {
                books.add(Book(it.id, it.author, it.country, it.imageLink, it.language, "",0,it.title,0,0,0,false))
            }

            return books
        }

        fun convertOneBookEntity(book: Book): BookEntity {

            return BookEntity(book.id!!,book.author!!,book.country!!,book.imageLink!!,book.language!!, book.link!!, book.pages!!, book.title!!, book.year!!, book.price!!, book.lastPrice!!, book.delivery!!)
        }

        fun convertOneBook(bookEntity: BookEntity): Book {


            return Book(bookEntity.id,bookEntity.author,bookEntity.country,bookEntity.imageLink,bookEntity.language, bookEntity.link, bookEntity.pages, bookEntity.title, bookEntity.year, bookEntity.price, bookEntity.lastPrice, bookEntity.delivery)

        }
    }
}