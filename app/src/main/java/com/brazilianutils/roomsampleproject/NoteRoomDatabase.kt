package com.brazilianutils.roomsampleproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        private var instance: NoteRoomDatabase? = null

        fun getInstance(context: Context): NoteRoomDatabase {
            return instance?.let {
                instance
            } ?: synchronized(NoteRoomDatabase::class) {
                Room.databaseBuilder(context, NoteRoomDatabase::class.java, "notes.db").build().also {
                    instance = it
                }
            }
        }
    }
}