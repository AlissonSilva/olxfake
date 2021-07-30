package com.example.olxfake.commons

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.olxfake.R
import com.example.olxfake.modals.Anuncio
import com.example.olxfake.ui.anuncio.ActiveAnuncio
import com.example.olxfake.ui.anuncio.AnuncioFragment
import com.example.olxfake.ui.home.AnunciosViewModel
import kotlin.coroutines.coroutineContext


class AdapterAnuncio (val dataSet : List<Anuncio>) : RecyclerView.Adapter<AdapterAnuncio.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tituloAnuncio = itemView.findViewById<TextView>(R.id.txtTituloAnuncio)
        val valor = itemView.findViewById<TextView>(R.id.txtPreco)
        val imgAnuncio = itemView.findViewById<ImageView>(R.id.imgAnuncio)
        val dataHoraCadastro = itemView.findViewById<TextView>(R.id.data_publicacao)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_anuncio, parent, false)

        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAnuncio = dataSet[position]
        holder.tituloAnuncio.text = currentAnuncio.titulo
        holder.valor.text = "R$ ${currentAnuncio.valor}"
        holder.imgAnuncio.load(currentAnuncio.img_principal)
        holder.dataHoraCadastro.text = currentAnuncio.data_hora_cadastro

        holder.itemView.setOnClickListener {
            Log.d("Class AdapterAnuncio ", "onBindViewHolder: Teste de click "+dataSet[position])
            val context = holder.tituloAnuncio.context
            val intent = Intent(context, ActiveAnuncio::class.java)

            intent.putExtra("titulo", currentAnuncio.titulo)
            intent.putExtra("descricao", currentAnuncio.descricao)
            intent.putExtra("data_hora_cadastro", currentAnuncio.data_hora_cadastro)
            intent.putExtra("valor", currentAnuncio.valor)
            intent.putExtra("img_principal", currentAnuncio.img_principal)
            intent.putExtra("telefon1", currentAnuncio.telefone1)
            intent.putExtra("telefon2", currentAnuncio.telefone2)
            intent.putExtra("id_anuncio", currentAnuncio.id_anuncio)
            intent.putExtra("idusuario", currentAnuncio.id_usuario)
            intent.putExtra("idcategoria", currentAnuncio.id_categoria)
            context.startActivity(intent)

        }
    }


}

