package com.example.anchor_book.data.db

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {

    private val PREFS_NAME = "com.example.anchor_book"
    private val SHARED_ID_BOOK = "shared.id_book"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var idBook: Int?
        get() = prefs.getInt(SHARED_ID_BOOK, 1)
        set(value) = prefs.edit().putInt(SHARED_ID_BOOK, value!!).apply()



}