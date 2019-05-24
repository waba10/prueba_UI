package com.ayala.uii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayala.uii.Adapter.BookAdapter
import com.ayala.uii.models.Book
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var moneda: MutableList<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        moneda = MutableList(10) { i ->
            Log.d("prueba", i.toString())


            Book(1, "titulo", 1, "editorial", 1, "resumen")

        }
        initRecycler()
    }

    fun initRecycler() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = BookAdapter(moneda)

        rv_book_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
