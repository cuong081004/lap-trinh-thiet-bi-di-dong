package com.example.noteapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.models.Note


@Database(

    entities = [Note::class],
    version = 1,
    exportSchema = false
)


abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): DAO


    companion object {

        @Volatile
        private var instance: NoteDataBase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }




        private fun createDatabase(context: Context) = Room.databaseBuilder(

            context.applicationContext,
            NoteDataBase::class.java,
            "note_database"

        ).build()


    }


}