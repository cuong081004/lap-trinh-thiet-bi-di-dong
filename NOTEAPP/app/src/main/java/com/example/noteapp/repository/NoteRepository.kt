package com.example.noteapp.repository

import com.example.noteapp.db.NoteDataBase
import com.example.noteapp.models.Note

class NoteRepository(private val db: NoteDataBase) {

    fun getNote() = db.getNoteDao().getAllNotes();

    fun searchNote(query: String) = db.getNoteDao().searchNote(query)

    suspend fun addNote(note: Note) = db.getNoteDao().addNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

}