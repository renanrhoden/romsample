package com.brazilianutils.roomsampleproject

import android.app.Application
import android.os.AsyncTask

class NoteRepository(application: Application) {

    private val db = NoteRoomDatabase.getInstance(application)
    private val wordDao = db.noteDao()
    val allWords = wordDao.getAllWords()

    fun insert(note: Note) {
        InsertAsyncTask(wordDao).execute(note)
    }

    fun deleteAll(){
        DeleteAllAsyncTask(wordDao).execute()
    }

    fun delete(note: Note){
        DeleteAsyncTask(wordDao).execute(note)
    }

    companion object {
        class InsertAsyncTask(private val dao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
            override fun doInBackground(vararg params: Note) {
                dao.insert(params.first())
            }
        }

        class DeleteAllAsyncTask(private val dao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg params: Unit) {
                dao.deleteAll()
            }
        }
        class DeleteAsyncTask(private val dao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
            override fun doInBackground(vararg params: Note) {
                dao.delete(params.first())
            }
        }
    }
}