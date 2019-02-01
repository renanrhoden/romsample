package com.brazilianutils.roomsampleproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(context: Context) : RecyclerView.Adapter<WordListAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    var words: List<Word>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.recyclerview_item, parent))
    }

    override fun getItemCount(): Int {
        return words?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        words?.let {
            holder.bind(it[position])
        }
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.text)
        fun bind(word: Word) {
            textView.text = word.word
        }
    }
}