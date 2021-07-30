package com.example.olxfake.modals

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_anuncio")
data class Anuncio (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_anuncio")
    val id_anuncio : Int,
    @ColumnInfo(name = "titulo")
    val titulo : String,
    @ColumnInfo(name = "descricao")
    val descricao : String,
    @ColumnInfo(name = "id_usuario")
    val id_usuario : Int,
    @ColumnInfo(name = "valor")
    val valor : Float,
    @ColumnInfo(name = "id_categoria")
    val id_categoria : Int,
    @ColumnInfo(name = "telefone1")
    val telefone1 : String,
    @ColumnInfo(name = "telefone2")
    val telefone2 : String,
    @ColumnInfo(name = "img_principal")
    val img_principal : String,
    @ColumnInfo(name = "data_hora_cadastro")
    val data_hora_cadastro : String

)