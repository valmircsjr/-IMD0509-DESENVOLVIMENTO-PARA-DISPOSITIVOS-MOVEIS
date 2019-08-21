package com.example.primeiraaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     * Cria a instancia da activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* set qual e o "front end" da atividade */
        setContentView(R.layout.activity_main)

        var isBack = intent.getStringExtra("isBack")

        if (isBack == "yes") {
            var view = TextView(this)
            view.text = intent.getStringExtra("text")
            setContentView(view)
        }
    }

    /**
     * Função para chamar nova activity
     */
    fun next(view: View){

        /* Para chamar outra activity*/
        var intent = Intent(applicationContext, Main2Activity::class.java)
        startActivity(intent)
    }
}
