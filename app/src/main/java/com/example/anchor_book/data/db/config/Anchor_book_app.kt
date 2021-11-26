package com.example.anchor_book.data.db.config

import android.app.Application
import androidx.room.Room
import com.example.anchor_book.data.db.Prefs

class Anchor_book_app: Application() {

    companion object{
        lateinit var db:DB
        lateinit var prefs:Prefs
    }

    override fun onCreate(){
        super.onCreate()
        db = Room.databaseBuilder(this, DB::class.java, "dbanchorbook").build()

        prefs = Prefs(applicationContext)
    }

}