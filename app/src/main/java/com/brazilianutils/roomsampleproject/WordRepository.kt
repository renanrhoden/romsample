package com.brazilianutils.roomsampleproject

import android.app.Application
import android.os.AsyncTask

class WordRepository(application: Application) {

    private val db = WordRoomDatabase.getInstance(application)
    private val wordDao = db.wordDao()
    val allWords = wordDao.getAllWords()

    fun insert(word: Word) {
        InsertAsyncTask(wordDao).execute(word)
    }

    companion object {
        class InsertAsyncTask(val dao: WordDao) : AsyncTask<Word, Unit, Unit>() {
            override fun doInBackground(vararg params: Word) {
                dao.insert(params.first())
            }
        }
    }
}