package com.example.anchor_book.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books")
data class BookEntity(


    @ColumnInfo(name ="id") @PrimaryKey val id : Int,
    @ColumnInfo(name ="author") val author : String,
    @ColumnInfo(name ="country") val country : String,
    @ColumnInfo(name ="imageLink") val imageLink : String,
    @ColumnInfo(name ="language") val language : String,
    @ColumnInfo(name ="link") val link : String,
    @ColumnInfo(name ="pages") val pages : Int,
    @ColumnInfo(name ="title") val title : String,
    @ColumnInfo(name ="year") val year : Int,
    @ColumnInfo(name ="price") val price : Int,
    @ColumnInfo(name ="lastPrice") val lastPrice : Int,
    @ColumnInfo(name ="delivery") val delivery : Boolean


)
