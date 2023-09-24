package com.example.picker

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.activity_second
import com.example.picker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val from = resources.getStringArray(R.array.from)

        with(binding){
            val fromAdpter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item , from)
            fromAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fromSpin.adapter = fromAdpter

            val toAdpter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item , from)
            toAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            toSpin.adapter = toAdpter

            airline.setOnClickListener {
                // Get the selected items from the spinners
                val selectedFrom = fromSpin.selectedItem.toString()
                val selectedTo = toSpin.selectedItem.toString().trim()
                // Create an Intent to start the second activity
                val intent = Intent(this@MainActivity, activity_second::class.java)
                // Add the selected items as extras to the Intent
                intent.putExtra("selectedFrom", selectedFrom)
                intent.putExtra("selectedTo", selectedTo)
                // Start the second activity
                startActivity(intent)
            }

//            backBtn.setOnClickListener{
//                val intent = Intent(this@MainActivity, activity_second::class.java)
//                startActivity(intent)
//            }

//            intent.putExtra(EXTRA_NAME, test.trim())
//            intent.putExtra(EXTRA_NAME, to2)


        }


    }


}