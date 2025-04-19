package com.example.noteapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.models.Note


@Dao
interface DAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)


    @Update
    suspend fun updateNote(note: Note)


    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>


    @Query("SELECT * FROM note WHERE title LIKE:query OR content LIKE :query OR date LIKE :query ORDER BY id DESC")
    fun searchNote(query: String): LiveData<List<Note>>


    @Delete
    suspend fun deleteNote(note: Note)



}