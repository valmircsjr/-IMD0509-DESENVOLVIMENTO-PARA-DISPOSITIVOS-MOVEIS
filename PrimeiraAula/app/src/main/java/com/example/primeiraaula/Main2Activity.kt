package com.example.primeiraaula

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
 * Métodos de callback invocados pelo Android durante o ciclo de vida da activity
 * Log.v() - Verbose (depuração detalhada)
 * Log.d() - Debug (depuração)
 * Log.i() - Info (informação)
 * Log.w() - Warning (aviso)
 * Log.e() - Error (erro)
 */
class Main2Activity : AppCompatActivity() {

    private val TAG = "MyApp ------- "
    private var nome: String? = null
    private var email: String? =  null


    /* Primeiro ciclo da activity */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /* Acessa o campo da view pelo id definido */
        var txtNome = findViewById<TextView>(R.id.txtNome)
        var txtEmail = findViewById<TextView>(R.id.txtEmail)

        /* Acessa os dados da activity por meio da intent que o android fornece */
        nome =  intent.getStringExtra("nome")
        email =  intent.getStringExtra("email")

        /* Atribui o conteudo da intent (activity anterior) para os campos da atual */
        txtNome.text = nome
        txtEmail.text = email

        /* Logs no console */
        Log.d(TAG,"onCreate()")
    }

    /**
     * Simula salvemento no banco
     */
    fun save(view: View){
        /* Aparace um poup up na tela com a string */
        Toast.makeText(this, "Os seguintes dados foram salvos:\n " +
                "Nome: $nome \n " +
                "Email: $email", Toast.LENGTH_LONG).show()
    }

    /**
     * Voltar para a MainActivity
     */
    fun back(view: View){
        var intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    /**
     * Destruir activity quando o botao fisico e clicado
     */
    override fun onBackPressed() {
        var i = intent
        i.putExtra("msg", "Dados passados de outra Activity!")
        setResult(Activity.RESULT_OK, i)

        finish()
    }

    /* ----------------- Activity Cicle --------------- */
    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy()")
    }

    /* ---------------- Activity Cicle ---------------- */
}
