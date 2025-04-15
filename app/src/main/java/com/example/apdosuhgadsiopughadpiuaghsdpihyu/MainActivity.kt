package com.example.apdosuhgadsiopughadpiuaghsdpihyu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.apdosuhgadsiopughadpiuaghsdpihyu.dao.DataBase
import com.example.apdosuhgadsiopughadpiuaghsdpihyu.databinding.ActivityMainBinding
import com.example.apdosuhgadsiopughadpiuaghsdpihyu.entities.Task
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var db: DataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(applicationContext,DataBase::class.java, "tasks.db").build()

        binding.addButton.setOnClickListener {
            val title : String = binding.editTitle.text.toString().trim()
            val description : String = binding.editDescription.text.toString().trim()

            if (title.isNotBlank() && description.isNotBlank()) {
                val task = Task(title = title, description = description)
                insertTask(task)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun insertTask(task: Task) {
        lifecycleScope.launch {
            try {
                db.daoTask().insertTask(task)
                Toast.makeText(applicationContext, "Tarefa adicionada!", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Algo deu errado!", Toast.LENGTH_LONG).show()
            }
        }
    }
}