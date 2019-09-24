package br.com.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EditNoteActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        var btnGravar = findViewById<Button>(R.id.btnGravar)
        btnGravar.setOnClickListener(this)

        var btnCancelar = findViewById<Button>(R.id.btnCancelar)
        btnCancelar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        var id = view?.id
        if (id == R.id.btnGravar) {

            //TODO Colocar o dialog customizado para salvar o titulo

            val noteTitle = "nova Nota"
            val noteText = findViewById<TextView>(R.id.et_note_text).text.toString()

            val it = intent

            it.putExtra("noteTitle", noteTitle)
            it.putExtra("noteText", noteText)

            setResult(1,it)

            finish()
        } else {

            // TODO provavelmente so vai voltar para a lista sem fazer NADA
            Toast.makeText(this,"CANCELAR",Toast.LENGTH_SHORT).show()
        }
    }
}
