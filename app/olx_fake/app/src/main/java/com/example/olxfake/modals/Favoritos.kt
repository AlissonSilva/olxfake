package com.example.olxfake.modals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_favoritos")
data class Favoritos (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_anuncio")
    var idanuncio : Int,
    @ColumnInfo(name = "status", defaultValue = true.toString())
    val status : Boolean

)