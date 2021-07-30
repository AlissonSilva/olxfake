package com.example.olxfake.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.olxfake.modals.Categoria

@Dao
interface CategoriaDao {

    @Query("select * from tb_categoria")
    fun getAllLiveCategoria() : LiveData<List<Categoria>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoria(categoria: Categoria)
}