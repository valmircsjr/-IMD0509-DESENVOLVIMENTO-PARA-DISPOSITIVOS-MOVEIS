package br.com.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter (
    val notes : ArrayList<Note>,
    val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.note_item, parent, false)

        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val note = notes[viewHolder.adapterPosition]
            Toast.makeText(context,note.text,Toast.LENGTH_SHORT).show()

            // TODO Quando pressionar o item, irá popular a activity de edição
        }

        return viewHolder

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int = notes.size

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = notes[position].title

        holder.tvNote?.text = title
    }

}

// Holds the TextView that will add each note to
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvNote = view.tv_note
}
