package com.example.olxfake.ui.favoritos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.olxfake.repository.AppRepository

class FavoritosViewModel (application: Application) : AndroidViewModel(application){

    private val appRepository = AppRepository(application)

    init {
        appRepository.getAnunciosFavoritos()
    }

    fun getAllAnunciosFavoritos() = appRepository.getAnunciosFavoritos()

    fun refreshData(){
        appRepository.fetchDataFromServer()
    }
}