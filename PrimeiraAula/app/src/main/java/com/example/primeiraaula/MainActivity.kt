package com.example.primeiraaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var edtNome: EditText? = null
    private var edtEmail: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        /* Pega os dados de uma view na activity e passa para um tipo EditText */
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
    }

    /**
     * Função para chamar a proxima activity
     */
    fun next(view: View){

        /* Reponsavel por charmar a outra activity passando o contexto da atual */
        var intent = Intent(applicationContext, Main2Activity::class.java)

        /* Pega o conteudo dos campos e passa para uma variavel*/
        var nome = edtNome?.text.toString()
        var email = edtEmail?.text.toString()

        /* Coloca os dados detro da intent, para passar para outra activity */
        intent.putExtra("nome", nome)
        intent.putExtra("email", email)

        /* Inicia a activity aguardando um resultado*/
        startActivityForResult(intent, 10)
    }

    /**
     * Tratamento dos dados da activity fechada
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 10) {
            var msg = data?.getStringExtra("msg")
            var  txtMsg =  findViewById<TextView>(R.id.txtMsg)

            txtMsg.text = msg
        } else {
            var  txtMsg =  findViewById<TextView>(R.id.txtMsg)

            txtMsg.text = "Error ResultCode"
        }
    }
}
