package com.example.apdosuhgadsiopughadpiuaghsdpihyu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apdosuhgadsiopughadpiuaghsdpihyu.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}