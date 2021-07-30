package com.example.olxfake.repository

import android.content.Context
import android.util.Log
import com.example.olxfake.api.ApiService
import com.example.olxfake.database.AppDatabase
import com.example.olxfake.modals.Anuncio
import com.example.olxfake.modals.Categoria
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepository (context: Context){

    val database = AppDatabase.getInstance(context)

    fun getTodosAnuncios() = database.Dao().getAllLiveAnuncio()

    fun getCarregarCategorias() = database.categoridaDao().getAllLiveCategoria()

    fun getAnunciosFavoritos() = database.Dao().listarAnunciosFavoritos()

    fun carregarValorCategoriaServer(){
        val request = ApiService.getEndpoints()
        request.getTodasCategorias().enqueue(object : Callback<List<Categoria>>{
            override fun onFailure(call: Call<List<Categoria>>, t: Throwable) {
                Log.d("Falha", "Falha ao carregar as categorias "+t.message+" "+t.printStackTrace())
            }

            override fun onResponse(
                call: Call<List<Categoria>>,
                response: Response<List<Categoria>>
            ) {
                //Log.d("Sucesso", "Requisição Sucesso! ")
                if(response.code()==200){
                    val resultado = response.body()
                    resultado?.let {categoria ->
                        Log.d("AppRepository: ", "Log Anuncios "+categoria.toString())
                        categoria.forEach {
                            doAsync {
                                database.categoridaDao().insertCategoria(it)
                            }
                        }
                    }
                }
            }

        })
    }


    fun fetchDataFromServer(){
        val request = ApiService.getEndpoints()
        request.getAllAnuncios().enqueue(object : Callback<List<Anuncio>>{

            override fun onFailure(call: Call<List<Anuncio>>, t: Throwable) {
                Log.d("Falha", "Requisição Falhou! "+t.message+" "+t.printStackTrace())
            }

            override fun onResponse(
                call: Call<List<Anuncio>>,
                response: Response<List<Anuncio>>
            ) {
                if(response.code()==200){
                    val resultado = response.body()
                    resultado?.let {anuncios ->
                        Log.d("AppRepository: ", "Log Anuncios "+anuncios.toString())
                        anuncios.forEach {
                            doAsync {
                                database.Dao().addSingleAnuncio(it)
                            }
                        }
                    }
                }
            }

        })
    }

    fun saveAnuncioOnServer(anuncio: Anuncio){
        val request = ApiService.getEndpoints()
        val response = request.saveAnuncios(anuncio).enqueue(
            object : Callback<Anuncio>{
                override fun onFailure(call: Call<Anuncio>, t: Throwable) {
                    Log.e("Erro", "Erro ao cadastrar"+t.stackTrace+" mensagem "+t.message)
                }

                override fun onResponse(call: Call<Anuncio>, response: Response<Anuncio>) {
                    Log.d("Sucesso", "Sucesso ao cadastrar")
                    if(response.code() == 201) {
                        response.body()?.let {
                            doAsync {
                                database.Dao().addSingleAnuncio(it)
                            }
                        }
                    }
                }

            }
        )
    }

}