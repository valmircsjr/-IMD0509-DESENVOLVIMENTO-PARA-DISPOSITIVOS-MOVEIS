package br.com.appunidade2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_edit_note.view.*

class NoteAdapter (
   private var notes: List<Note>,
   private var callback: (Note)-> Unit
):RecyclerView.Adapter<NoteAdapter.VH>()  {

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.activity_list_notes, parent, false)

       val vh = VH(view)
       vh.itemView.setOnClickListener {
           val note = notes[vh.adapterPosition]
           callback(note)
       }

       return vh
   }

   override fun getItemCount(): Int = notes.size

   override fun onBindViewHolder(holder: VH, position: Int) {
       val title = notes[position]

       holder.note_title.text = title.toString()
   }


   /**
    * View Holder
    */
   class VH(itemView: View): RecyclerView.ViewHolder(itemView){
       val note_title: TextView = itemView.note_text
   }

}
