package com.example.olxfake.api

import com.example.olxfake.modals.Anuncio
import com.example.olxfake.modals.Categoria
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoints {

    @GET("api/anuncios/listar")
    fun getAllAnuncios() : Call<List<Anuncio>>

    @POST("api/anuncios/store")
    fun saveAnuncios(@Body anuncio: Anuncio) : Call<Anuncio>

    @GET("api/categorias/listar")
    fun  getTodasCategorias() : Call<List<Categoria>>
}