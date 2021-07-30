package com.example.olxfake.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.olxfake.modals.Anuncio
import com.example.olxfake.repository.AppRepository

class AnunciosViewModel (application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)

    init {
        appRepository.fetchDataFromServer()
        appRepository.carregarValorCategoriaServer()
    }

    fun getAllAnuncios() = appRepository.getTodosAnuncios()

    fun saveAnuncio(novoAnuncio : Anuncio){
        appRepository.saveAnuncioOnServer(novoAnuncio)
    }

    fun refreshData(){
        appRepository.fetchDataFromServer()
    }
}