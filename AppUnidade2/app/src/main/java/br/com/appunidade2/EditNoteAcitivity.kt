package br.com.appunidade2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditNoteAcitivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        var btnGravar = findViewById<Button>(R.id.gravar)
        btnGravar.setOnClickListener(this)

        var btnCancelar = findViewById<Button>(R.id.cancelar)
        btnCancelar.setOnClickListener(this)
    }

    override fun onClick(v : View?) {

        var id = v?.id
        if (id == R.id.gravar) {
            Toast.makeText(this,"Gravar",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Cancelar",Toast.LENGTH_SHORT).show()
        }
    }


}