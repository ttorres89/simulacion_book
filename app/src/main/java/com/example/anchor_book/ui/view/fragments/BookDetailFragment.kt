package com.example.anchor_book.ui.view.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchor_book.R
import com.example.anchor_book.data.db.config.Anchor_book_app.Companion.prefs
import com.example.anchor_book.databinding.FragmentBookDetailBinding
import com.example.anchor_book.databinding.FragmentBooksBinding
import com.example.anchor_book.ui.view.adapter.CustomAdapter
import com.example.anchor_book.ui.view.interfaces.IcomunicateBook
import com.example.anchor_book.ui.viewmodel.BookDetailViewModel
import com.example.anchor_book.ui.viewmodel.BookViewModel
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentBookDetailBinding?=null
    private val binding get() = _binding!!
    lateinit var activity:Activity
    lateinit var icomunicateBook: IcomunicateBook
    private lateinit var bookViewModel: BookViewModel


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

        _binding = FragmentBookDetailBinding.inflate(inflater,container,false)
        this.bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        initBook()
        inicializarBtnMenuPrincipal()
        initsendEmail()

        return binding.root
    }

    private fun initBook(){
        this.bookViewModel.detail_book.observe(viewLifecycleOwner, Observer {

            binding.titleDetail.setText(it.title)
            binding.autorDetail.setText(it.author)
            binding.priceDetail.setText(it.price.toString())
            binding.itemNumpageDetail.setText(it.pages.toString())
            Picasso.with(context).load(it.imageLink).into(binding.itemImageDetail);

        })
    }

    private fun inicializarBtnMenuPrincipal()
    {
        binding.btnAtras.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                icomunicateBook.viewBooks()
            }
        })
    }

    private fun initsendEmail()
    {
        binding.buttonBuy.setOnClickListener {

            val recipient = "torres.tania89@gmail.com"
            val subject =  "Consulta por libro: " + binding.titleDetail.text.toString() + " id: " + prefs.idBook

            val message = "Hola\n\n" +
                    "Vi el libro: " + binding.titleDetail.text.toString() +" de código: "+ prefs.idBook +
                    " y me gustaría que me contactaran a este correo o al siguiente número ______________\n\n" +
                    "Quedo atento."

            //method call for email intent with these inputs as parameters
            sendEmail(recipient, subject, message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
        }

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
         * @return A new instance of fragment BookDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}