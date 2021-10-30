package com.example.anchor_book.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anchor_book.R
import com.example.anchor_book.data.model.Book
import com.squareup.picasso.Picasso

class CustomAdapter (private val bookList:List<Book>, private val context: Context): RecyclerView.Adapter<CustomAdapter.ViewHolder>(), View.OnClickListener {

    private lateinit var  listener: View.OnClickListener

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemId: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemId = itemView.findViewById(R.id.item_id)


        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        v.setOnClickListener(this)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = bookList[i].title
        viewHolder.itemDetail.text = bookList[i].author
        Picasso.with(context).load(bookList[i].imageLink).placeholder(R.drawable.placeholder).error(R.drawable.error).fit().centerInside().noFade().into(viewHolder.itemImage)
        viewHolder.itemId.text = bookList[i].id.toString()
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun onClick(v: View?) {
        if (listener!=null){
            listener.onClick(v)
        }
    }
}