package com.ayala.uii.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayala.uii.R
import com.ayala.uii.SecondActivity
import com.ayala.uii.models.Book

class BookAdapter(val items: List<Book>): RecyclerView.Adapter<BookAdapter.ViewHolder>
    () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_element_book, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) = holder.bind(items[position])

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var tvTitulo: TextView
        lateinit var tvEdicion: TextView
        lateinit var tvEditorial: TextView
        lateinit var tvISBN: TextView
        lateinit var tvResumen: TextView

        fun bind(libro: Book) = with(itemView){
            Log.d("CUSTOM",libro.titulo)
            tvTitulo =  findViewById(R.id.titulo)
            tvTitulo.text = libro.titulo
            tvEdicion =  findViewById(R.id.edicion)
            tvEdicion.text = libro.edicion.toString()
            tvEditorial =  findViewById(R.id.editorial)
            tvEditorial.text = libro.editorial
            tvISBN =  findViewById(R.id.isbn)
            tvISBN.text = libro.isbn.toString()
            tvResumen =  findViewById(R.id.resumen)
            tvResumen.text = libro.resumen

            this.setOnClickListener {
                var mIntent = Intent(it.context,  SecondActivity:: class.java)
                mIntent.putExtra("key_nombre", libro.resumen)
                mIntent.putExtra("key_ambito", libro.titulo)
                this.context.startActivity(mIntent)
            }
        }
    }

}