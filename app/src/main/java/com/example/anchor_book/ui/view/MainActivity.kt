package com.example.anchor_book.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchor_book.R
import com.example.anchor_book.databinding.ActivityMainBinding
import com.example.anchor_book.ui.view.adapter.CustomAdapter
import com.example.anchor_book.ui.view.fragments.BooksFragment
import com.example.anchor_book.ui.view.interfaces.IcomunicateBook
import com.example.anchor_book.ui.viewmodel.BookViewModel

class MainActivity : AppCompatActivity(), IcomunicateBook {

    private lateinit var  viewModel: BookViewModel
    private lateinit var adapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        this.viewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        setContentView(binding.root)
        viewBooks()

        /*viewModel.books.observe(this, {
            Log.d("books_observe",it.toString())
            adapter = CustomAdapter(it, this)
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter=adapter

            adapter.setOnClickListener(object: View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent= Intent(applicationContext, Visor_detalle::class.java)
                    val id_book = it.get(binding.recyclerView.getChildAdapterPosition(v!!)).id
                    Log.d("id_mainAc", id_book.toString())
                    startActivity(intent.putExtra("idbook",id_book))
                }
            })

        })*/

    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bookContent, fragment)
        fragmentTransaction.commit()
    }


    override fun viewBooks() {
        replaceFragment(BooksFragment())
    }

    override fun viewBookDetail(id_book: Int) {
        //replaceFragment(AlumnosNotasFragment())
    }
}