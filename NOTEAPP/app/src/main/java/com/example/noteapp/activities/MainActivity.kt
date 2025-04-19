package com.example.noteapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.db.NoteDataBase
import com.example.noteapp.repository.NoteRepository
import com.example.noteapp.viewModel.NoteActivityViewModel
import com.example.noteapp.viewModel.NoteActivityViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        try {
            setContentView(binding.root)
            val noteRepository= NoteRepository(NoteDataBase(this))
            val noteActivityViewModelFactory= NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel= ViewModelProvider(this,
                noteActivityViewModelFactory)[NoteActivityViewModel::class.java]
        } catch (e: Exception) {
            Log.d("TAG", "Error")
        }
    }
}