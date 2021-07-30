package com.example.olxfake.modals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_categoria")
data class Categoria(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_categoria")
    val id_categoria : Int,
    @ColumnInfo(name = "descricao")
    val descricao : String,
    @ColumnInfo(name = "icon_categoria")
    val icon_categoria : String

)