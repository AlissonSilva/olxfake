package com.example.olxfake.ui.cadastro

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.olxfake.MainActivity
import com.example.olxfake.R
import com.example.olxfake.modals.Anuncio
import kotlinx.android.synthetic.main.fragment_cadastro.*
import java.time.LocalDateTime

class CadastroFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }


    override fun onResume() {
        super.onResume()

        cadastroViewModel = ViewModelProviders.of(this).get(CadastroViewModel::class.java)

        btnenviarcadastro.setOnClickListener {
            try {
                val titulo = idtitulocadastro.text.toString()
                val descricao = iddescricaocadastro.text.toString()
                val urlimage = imganunciocadastro.text.toString()
                val valor = idvalorcadastro.text.toString().toFloat()
                val idcategoria = 1
                val idtelefone1 = idtelefone1.text.toString()
                val idtelefone2 = idtelefone2.text.toString()

                val novoAnuncio = Anuncio(1,titulo,descricao,1,valor,idcategoria,idtelefone1,idtelefone2,urlimage,
                    "12-27-2019 00:00:00"
                )

                cadastroViewModel.saveAnuncio(novoAnuncio)

                Toast.makeText(context, "Anuncio salvo com sucesso", Toast.LENGTH_SHORT).show()

                chamarAlert()

            } catch (e : Exception) {
                //Apresentar mensagem de erro
                Toast.makeText(context, "Erro ao inserir um anúncio", Toast.LENGTH_SHORT).show()
                //it.findNavController().popBackStack()
            }

        }


    }


    fun chamarAlert() {

        context

        var alertDialog = context?.let { AlertDialog.Builder(it) }
        alertDialog!!.setTitle("Alerta") // O Titulo da notificação
        alertDialog.setMessage("Anuncio salvo com sucesso! \n Deseja inserir outro anuncio?") // a mensagem ou alerta

        alertDialog.setPositiveButton("Sim", { _, _ ->
            iddescricaocadastro.setText("")
            idtitulocadastro.setText("")
            imganunciocadastro.setText("")
            idtelefone1.setText("")
            idtelefone2.setText("")
            idvalorcadastro.setText("")


        })

        alertDialog.setNegativeButton("Não") { _, _ ->
            val x : Context = idtelefone1.context
            val parseIntent = Intent(x,MainActivity::class.java)
            x.startActivity(parseIntent)
        }
        alertDialog.show()

    }
}