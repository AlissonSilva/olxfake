package com.example.olxfake.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.olxfake.R
import com.example.olxfake.commons.AdapterAnuncio
import kotlinx.android.synthetic.main.fragment_favoritos.*
import kotlinx.android.synthetic.main.fragment_home.*

class FavoritosFragment : Fragment() {

    lateinit var favoritosViewModel: FavoritosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }

    override fun onResume() {
        super.onResume()



        favoritosViewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)

        favoritosViewModel.refreshData()

        favoritosViewModel.getAllAnunciosFavoritos().observe(this, Observer { anuncio ->
            rcListaFavoritosAnuncios.adapter = AdapterAnuncio(anuncio)
        })



    }
}