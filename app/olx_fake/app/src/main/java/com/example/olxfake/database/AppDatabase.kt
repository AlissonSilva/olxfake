package com.example.olxfake.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.olxfake.modals.Anuncio
import com.example.olxfake.modals.Categoria
import com.example.olxfake.modals.Favoritos

@Database(entities = arrayOf(Anuncio::class,Favoritos::class, Categoria::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun Dao(): AnuncioDao
    abstract fun favoritosDao() : FavoritosDao
    abstract fun categoridaDao() : CategoriaDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database.db"
                ).build()
                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
        }
    }
}