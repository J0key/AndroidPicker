package com.example.picker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.picker.databinding.ActivityFourBinding

class activity_four: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}