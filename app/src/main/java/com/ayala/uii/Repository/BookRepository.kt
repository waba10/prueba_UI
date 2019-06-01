package com.ayala.uii.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.ayala.uii.DAO.BookDao
import com.ayala.uii.Entity.Book

class BookRespository(private val libroDao: BookDao) {

    val allBooks: LiveData<List<Book>> = libroDao.getBooks()

    @WorkerThread
    suspend fun insert(book: Book){
        libroDao.insert(book)
    }
    fun getAll():LiveData<List<Book>> = libroDao.getBooks()

}