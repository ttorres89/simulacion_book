package com.example.anchor_book.data.db.config

import android.app.Application
import androidx.room.Room

class Anchor_book_app: Application() {

    companion object{
        lateinit var db:DB
    }

    override fun onCreate(){
        super.onCreate()
        db = Room.databaseBuilder(this, DB::class.java, "dbanchorbook").build()
    }

}