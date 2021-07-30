package com.example.olxfake.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.olxfake.modals.Anuncio

@Dao
interface AnuncioDao{

    @Query("select * from tb_anuncio order by id_anuncio desc")
    fun getAllAnuncio() : List<Anuncio>

    @Query("select * from tb_anuncio order by id_anuncio desc")
    fun getAllLiveAnuncio() : LiveData<List<Anuncio>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSingleAnuncio(novoAnuncio: Anuncio)

    @Query("select * from tb_anuncio where exists (select id_anuncio from tb_favoritos where tb_favoritos.id_anuncio = tb_anuncio.id_anuncio)")
    fun listarAnunciosFavoritos() : LiveData<List<Anuncio>>

    @Update
    fun updateAnuncio(anuncioAtualizado : Anuncio)

}