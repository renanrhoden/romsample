package com.brazilianutils.roomsampleproject

import androidx.lifecycle.ViewModel

class NoteViewModel(private val repo: NoteRepository) : ViewModel() {

    val allNotes = repo.allWords

    fun insert(note: Note) {
        repo.insert(note)
    }

    fun deleteAll(){
        repo.deleteAll()
    }

    fun delete(note: Note){
        repo.delete(note)
    }
}