package com.example.anchor_book.data.model

import com.google.gson.annotations.SerializedName

data class Book (


    @SerializedName("id") val id : Int,
    @SerializedName("author") val author : String,
    @SerializedName("country") val country : String,
    @SerializedName("imageLink") val imageLink : String,
    @SerializedName("language") val language : String,
    @SerializedName("link") val link : String? = null,
    @SerializedName("pages") val pages : Int? = null,
    @SerializedName("title") val title : String,
    @SerializedName("year") val year : Int? = null,
    @SerializedName("price") val price : Int? = null,
    @SerializedName("lastPrice") val lastPrice : Int? = null,
    @SerializedName("delivery") val delivery : Boolean? = null

    )