package com.example.anchor_book.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.anchor_book.R
import com.example.anchor_book.ui.viewmodel.BookViewModel

class Visor_detalle : AppCompatActivity() {


    private lateinit var  viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_detalle)
        this.viewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        var id = intent.getIntExtra("idbook",0)
        Log.d("id_book", id.toString())
        if(id!=null){

            this.viewModel.buscarLibro(id.toInt())
        }


        Log.d("lib_b",this.viewModel.book.toString() )


    }
}