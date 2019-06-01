package com.ayala.uii.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayala.uii.Entity.Book
import com.ayala.uii.Repository.BookRespository
import com.ayala.uii.Room.BookRoomDatabase
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRespository

    val allBooks: LiveData<List<Book>>

    init{
        val booksDao = BookRoomDatabase.getDatabase(application, viewModelScope).bookDao()
        repository= BookRespository(booksDao)
        allBooks=repository.allBooks
    }

    fun insert(book: Book)= viewModelScope.launch{
        repository.insert(book)

    }
    fun getAll():LiveData<List<Book>> = repository.getAll()
}