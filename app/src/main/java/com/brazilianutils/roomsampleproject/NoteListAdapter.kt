package com.brazilianutils.roomsampleproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(context: Context, val listener: (note: Note) -> Unit) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    var notes: List<Note>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false), listener)
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        notes?.let {
            holder.bind(it[position])
        }
    }

    class ViewHolder(view: View, val listener: (note: Note) -> Unit) : RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.text)

        fun bind(note: Note) {
            textView.text = note.note
            itemView.setOnLongClickListener {
                listener(note)
                true
            }
        }
    }
}