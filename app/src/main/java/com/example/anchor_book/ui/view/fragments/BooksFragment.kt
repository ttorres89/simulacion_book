package com.example.anchor_book.ui.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchor_book.data.db.config.Anchor_book_app.Companion.prefs
import com.example.anchor_book.databinding.FragmentBooksBinding
import com.example.anchor_book.ui.view.adapter.CustomAdapter
import com.example.anchor_book.ui.view.interfaces.IcomunicateBook
import com.example.anchor_book.ui.viewmodel.BookViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BooksFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentBooksBinding?=null
    private val binding get() = _binding!!

    private var param1: String? = null
    private var param2: String? = null

    lateinit var activity:Activity
    lateinit var viewA:View
    lateinit var icomunicateBook: IcomunicateBook
    private lateinit var bookViewModel: BookViewModel
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBooksBinding.inflate(inflater,container,false)
        this.bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView(){

        bookViewModel.books.observe(viewLifecycleOwner, Observer {

            Log.d("books_observe",it.toString())
            adapter = CustomAdapter(it, requireContext())
            binding.recyclerBooks.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerBooks.adapter=adapter

            adapter.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                     val id_book:Int = it.get(binding.recyclerBooks.getChildAdapterPosition(v!!)).id

                    prefs.idBook = id_book

                    Log.d("id", id_book.toString())
                    icomunicateBook.viewBookDetail()
                }
            }
            )
        })


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        icomunicateBook = activity as IcomunicateBook
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BooksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BooksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}