package com.ayala.uii.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ayala.uii.Entity.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM Book_table")
    fun getBooks(): LiveData<List<Book>>

    @Insert
    suspend fun insert(book: Book)

    @Query("SELECT * FROM Book_table WHERE titulo LIKE:titulo")
    fun searchTitle(titulo:String): LiveData<List<Book>>
}