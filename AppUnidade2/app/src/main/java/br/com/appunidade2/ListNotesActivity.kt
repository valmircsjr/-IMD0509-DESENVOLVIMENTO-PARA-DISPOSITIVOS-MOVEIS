package br.com.appunidade2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_notes.*

class ListNotesActivity : AppCompatActivity() {

   private var notes = mutableListOf<Note>()
   private var adapter = NoteAdapter(notes, this::onNoteItemClick)

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_list_notes)
       initRecyclerView()

   }

   /**
    * Inicia o recyclerview
    */
   private fun initRecyclerView() {
       rv_note_list.adapter = adapter
       initSwipeDelete()
   }

   /**
    * Alguma coisa
    */
   private fun initSwipeDelete(){
       val swipe = object : ItemTouchHelper.SimpleCallback(
           0,
           ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
       ){
           override fun onMove(
               recyclerView: RecyclerView,
               viewHolder: RecyclerView.ViewHolder,
               target: RecyclerView.ViewHolder
           ): Boolean = false

           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               val position = viewHolder.adapterPosition
               notes.removeAt(position)
               adapter.notifyItemRemoved(position)
           }
       }
       val itemTouchHelper = ItemTouchHelper(swipe)
       itemTouchHelper.attachToRecyclerView(rv_note_list)
   }

   /**
    * Mensagem de notificação.
    */
   private fun onNoteItemClick(note: Note){
       var s = "${note.title}"
       Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
   }

}
