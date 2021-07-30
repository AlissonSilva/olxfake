package com.example.olxfake.ui.cadastro

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.olxfake.modals.Anuncio
import com.example.olxfake.repository.AppRepository

class CadastroViewModel (application: Application) : AndroidViewModel(application){

    private val appRepository = AppRepository(application)

    init {
        appRepository.fetchDataFromServer()
    }

    fun saveAnuncio(novoAnuncio : Anuncio){
        appRepository.saveAnuncioOnServer(novoAnuncio)

    }
}