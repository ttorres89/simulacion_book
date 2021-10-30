package com.example.anchor_book.data.db.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anchor_book.data.db.dao.BookDao
import com.example.anchor_book.data.db.entities.BookEntity


@Database(
    entities = [BookEntity::class],
    version = 4,
    exportSchema = false)
abstract class DB : RoomDatabase() {
    abstract fun bookDao(): BookDao
}