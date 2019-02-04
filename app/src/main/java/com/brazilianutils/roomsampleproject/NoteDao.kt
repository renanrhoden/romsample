package com.brazilianutils.roomsampleproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT * from note_table ORDER BY note ASC")
    fun getAllWords(): LiveData<List<Note>>
}