package com.example.primeiraaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main2Activity : AppCompatActivity() {

    /**
     * Cria a instancia da activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    /**
     * Função para chamar activity1
     */
    fun back(view: View){

        /* Para chamar outra activity*/
        var intent = Intent(applicationContext, MainActivity::class.java)
        intent.putExtra("text", "Voce esta de volta!")
        intent.putExtra("isBack", "yes")

        startActivity(intent)
    }
}
