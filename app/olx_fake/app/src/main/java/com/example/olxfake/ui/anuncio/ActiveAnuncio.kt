package com.example.olxfake.ui.anuncio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import coil.api.load
import com.example.olxfake.R
import com.example.olxfake.database.AppDatabase
import com.example.olxfake.modals.Favoritos
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.doAsync

class ActiveAnuncio : AppCompatActivity() {

    val database = AppDatabase.getInstance(this)
    var objFavorito = Favoritos(0,false)
    var verificador : String = ""
    var verificadorMenu : Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.active_anuncio)

        val id_anuncio : Int = intent.getIntExtra("id_anuncio",1)
        val titulo : String = intent.getStringExtra("titulo")
        val descricao : String = intent.getStringExtra("descricao")
        val data_hora_cadastro : String = intent.getStringExtra("data_hora_cadastro")
        val valor : Float = intent.getFloatExtra("valor",1f)
        val img_principal : String = intent.getStringExtra("img_principal")
        val telefon1 : String = intent.getStringExtra("telefon1")
        val telefon2 : String = intent.getStringExtra("telefon2")
        val idusuario : Int = intent.getIntExtra("idusuario",1)
        val idcategoria : Int = intent.getIntExtra("idcategoria",1)

        val mToolbar : Toolbar = findViewById(R.id.toolbarAnuncio)
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val txtTitulo : TextView = findViewById(R.id.txtTituloAnuncioAct)
        val txtDescricao : TextView = findViewById(R.id.txtDescricaoAct)
        val txtDataHoraCadastro : TextView = findViewById(R.id.txtDtPublicaoAct)
        val txtValor : TextView = findViewById(R.id.txtValorAct)
        val txtTelefone1 : TextView = findViewById(R.id.txtTelefone1)
        val imgPrincipal : ImageView = findViewById(R.id.imgAnuncioAct)

        txtTitulo.setText(titulo)
        txtDescricao.setText(descricao)
        txtDataHoraCadastro.setText("Publicado em "+data_hora_cadastro)
        txtTelefone1.setText("Telefone "+telefon1)
        txtValor.setText("R$"+valor.toString())
        imgPrincipal.load(img_principal)

        objFavorito.idanuncio = id_anuncio



        Log.d("ActiveAnuncio ","titulo: "+titulo)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_action_anuncio, menu)
        Log.d("verificação", "chegou onCreateOptionsMenu")
        return true
    }

    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
        onPrepareOptionsMenu(menu)
        return super.onMenuOpened(featureId, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        var verificadorStatus : String = ""
        doAsync{
            verificadorStatus = database.favoritosDao().verificarAnuncioFavorito(objFavorito.idanuncio).toString()
            if (verificadorStatus == "true"){
                Log.d("verificação","onPrepareOptionsMenu true")
                menu.findItem(R.id.act_favoritar).setIcon(R.drawable.ic_favorito_true)
            }else{
                Log.d("verificação","onPrepareOptionsMenu false")
            }
        }
        Log.d("verificação","onPrepareOptionsMenu return")
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val v : View = findViewById(R.id.active_anuncio)
        val id  = item.itemId
        var verificadorStatus : String = ""
        if( id == R.id.act_favoritar ){
            doAsync{
                verificadorStatus = database.favoritosDao().verificarAnuncioFavorito(objFavorito.idanuncio).toString()
                if (verificadorStatus == "false"){
                    database.favoritosDao().insertFavoritos(objFavorito)
                    runOnUiThread {
                        item.setIcon(R.drawable.ic_favorito_true)
                        Log.d("verificação", "verificadorStatus falso")
                    }

                    val snackbar = Snackbar.make(  v, "ANÚNCIO FAVORITADO", Snackbar.LENGTH_SHORT)

                    snackbar.setActionTextColor(
                        ContextCompat.getColor(baseContext, R.color.textSnackbar)
                    )

                    val snackbarView = snackbar.view
                    val textView = snackbarView.findViewById<TextView>(R.id.snackbar_text)
                    textView.maxLines = 2
                    textView.setTextColor(
                        ContextCompat.getColor(
                            baseContext,
                            R.color.textSnackbar
                        )
                    )
                    snackbarView.setBackgroundColor(
                        ContextCompat.getColor(
                            baseContext,
                            R.color.backgroundSnackbar
                        )
                    )
                    snackbar.show()





                }else{
                    database.favoritosDao().deletelAnuncioFavorito(objFavorito)
                    runOnUiThread {
                        item.setIcon(R.drawable.ic_favorito)
                        Log.d("verificação", "verificadorStatus verdadeiro")
                    }
                }
            }

            Log.d("verificação", "chegou aqui dentro do primeiro if ")
            return true
        }else if( id == R.id.act_compartilhar){
            val sharedIntent = Intent(Intent.ACTION_SEND)
            sharedIntent.type = "Type/palin"
            sharedIntent.putExtra("titulo","teste")
            sharedIntent.putExtra("valor","valor")
            startActivity(Intent.createChooser(sharedIntent,"Compartilhar anúncio OLX_Fake") )
            return true
        }

        Log.d("verificação", "chegou o último ")
        return super.onOptionsItemSelected(item)
    }


}
