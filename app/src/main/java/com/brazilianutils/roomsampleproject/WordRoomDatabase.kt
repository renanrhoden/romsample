package com.brazilianutils.roomsampleproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        private var instance: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase {
            return instance?.let {
                instance
            } ?: synchronized(WordRoomDatabase::class) {
                Room.databaseBuilder(context, WordRoomDatabase::class.java, "word.db").build().also {
                    instance = it
                }
            }
        }
    }
}