package com.example.intent

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.picker.MainActivity
import com.example.picker.activity_third
import com.example.picker.databinding.ActivitySecondBinding

class activity_second : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val airline = resources.getStringArray(com.example.picker.R.array.airline)
        val class1 = resources.getStringArray(com.example.picker.R.array.ticket)
        val frommain = intent.getStringExtra("selectedFrom")
        val tomain = intent.getStringExtra("selectedTo")



        with(binding) {
            val airlineAdpter = ArrayAdapter(this@activity_second, R.layout.simple_spinner_dropdown_item , airline)
            airlineAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pickSpin.adapter = airlineAdpter

            val classAdpter = ArrayAdapter(this@activity_second, R.layout.simple_spinner_dropdown_item , class1)
            classAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            classSpin.adapter = classAdpter

            backBtn.setOnClickListener{
                val intent = Intent(this@activity_second, MainActivity::class.java)
                startActivity(intent)
            }

            day.setOnClickListener{
                val selectedAirline = pickSpin.selectedItem.toString()
                val selectedClass = classSpin.selectedItem.toString().trim()
                // Create an Intent to start the second activity
                val intent = Intent(this@activity_second, activity_third::class.java)
                // Add the selected items as extras to the Intent
                intent.putExtra("fromMain" , frommain)
                intent.putExtra("toMain" , tomain)
                intent.putExtra("selectedAirline" , selectedAirline)
                intent.putExtra("selectedClass", selectedClass)
                // Start the third activity
                startActivity(intent)
            }
        }

    }
}

