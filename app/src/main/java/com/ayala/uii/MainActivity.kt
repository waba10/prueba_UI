package com.ayala.uii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayala.uii.Adapter.BookAdapter
import com.ayala.uii.ViewModel.BookViewModel

import androidx.lifecycle.Observer
import com.ayala.uii.Entity.Book

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var libros: MutableList<Book>

    private val newBookActivityRequestCode = 1
    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.rv_book_list)
        val adapter = BookAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        viewModel.getAll().observe(this, Observer { books ->
            books?.let { adapter.setBooks(it) }
        })

        viewModel.getAll().observe(this, Observer { books ->
            for (books in books) {
                //Log.d("Lista de libros", books.titleEnglish + books.titleSpanish + books.editorial)
            }
        })

    }
}
