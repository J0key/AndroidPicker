package com.example.picker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class front : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity after the delay
            startActivity(Intent(this@front, MainActivity::class.java))
            finish() // Close the splash screen activity
        }, 3000)
    }
}