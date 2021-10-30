package com.example.anchor_book.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anchor_book.data.db.entities.BookEntity
import org.jetbrains.annotations.NotNull

@Dao
interface BookDao {

    @Query("SELECT * from books")
    suspend fun getAll(): List<BookEntity>

    @Query("SELECT * from books where books.id=:id")
    suspend fun getOneBook(@NotNull id: Int): BookEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook (@NotNull books: List<BookEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneBook (@NotNull books: BookEntity)

}