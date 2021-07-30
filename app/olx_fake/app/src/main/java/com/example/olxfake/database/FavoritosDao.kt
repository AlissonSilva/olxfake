package com.example.olxfake.database

import androidx.room.*
import com.example.olxfake.modals.Favoritos

@Dao
interface FavoritosDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoritos(favorito : Favoritos)

    @Query("select * from tb_favoritos where id_anuncio == :id")
    fun verificarAnuncioFavorito(id : Int) : Boolean

    @Delete
    fun deletelAnuncioFavorito(favorito : Favoritos)

}