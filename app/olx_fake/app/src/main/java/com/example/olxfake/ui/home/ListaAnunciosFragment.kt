package com.example.olxfake.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.olxfake.R
import com.example.olxfake.commons.AdapterAnuncio
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListaAnunciosFragment : Fragment() {

    lateinit var anunciosViewModel: AnunciosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)

        return view

    }

    override fun onResume() {
        super.onResume()

        anunciosViewModel = ViewModelProviders.of(this).get(AnunciosViewModel::class.java)

        anunciosViewModel.refreshData()

        anunciosViewModel.getAllAnuncios().observe(this, Observer { anuncio ->
            rcListaAnuncios.adapter = AdapterAnuncio(anuncio)
        })



    }
}