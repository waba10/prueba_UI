package com.ayala.uii.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayala.uii.Entity.Book
import com.ayala.uii.R
import com.ayala.uii.SecondActivity
import kotlinx.android.synthetic.main.list_element_book.view.*


class BookAdapter internal constructor(context: Context) :  RecyclerView.Adapter<BookAdapter.BookViewHolder>
    () {

    private var books = emptyList<Book>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_element_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookAdapter.BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    internal fun setBooks(words: List<Book>) {
        this.books = words
        notifyDataSetChanged()
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book) {
            with(itemView) {
                titulo.text=book.titulo
                edicion.text=book.edicion
                editorial.text=book.editorial
                isbn.text=book.isbn
                resumen.text=book.resumen


                this.setOnClickListener {
                    var mIntent = Intent(it.context,  SecondActivity:: class.java)
                    mIntent.putExtra("key_resumen", book.resumen)
                    mIntent.putExtra("key_titulo", book.titulo)
                    this.context.startActivity(mIntent)
                }

            }

        }
    }
}