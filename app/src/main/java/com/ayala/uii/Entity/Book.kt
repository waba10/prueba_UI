package com.ayala.uii.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Book_table")
data class Book (
    @ColumnInfo(name = "titulo") val titulo:String= "N/A",
    @ColumnInfo(name = "caratula") val caratula: String = "N/a",
    @ColumnInfo(name = "editorial") val editorial: String = "N/a",
    @ColumnInfo(name = "isbn") val isbn: String = "N/a",
    @ColumnInfo(name = "resumen") val resumen: String? = "N/a",
    @ColumnInfo(name = "id_tag") val id_tag: String = "N/a",
    @ColumnInfo(name = "edicion") val edicion: String = "N/a",
    @ColumnInfo(name = "favorito") val favorito: Boolean = true

){
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}