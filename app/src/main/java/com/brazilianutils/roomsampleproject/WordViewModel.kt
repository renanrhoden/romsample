package com.brazilianutils.roomsampleproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: WordRepository by lazy {
        WordRepository(application)
    }

    val allWords = repo.allWords

    fun insert(word: Word) {
        repo.insert(word)
    }
}