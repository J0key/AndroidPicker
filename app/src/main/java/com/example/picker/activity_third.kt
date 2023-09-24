package com.example.picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.picker.databinding.ActivityThirdBinding
import java.util.Locale



class activity_third : AppCompatActivity() {
    lateinit var Tvdate : TextView
    lateinit var dateSpin : Button
    lateinit var Tvtime : TextView
    lateinit var timeSpin : Button

    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Tvdate = findViewById<TextView>(R.id.result)
        dateSpin = findViewById<Button>(R.id.date_spin)
        Tvtime = findViewById<TextView>(R.id.result2)
        timeSpin = findViewById<Button>(R.id.time_spin)


        var formattedDate = ""
        dateSpin.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this, {DatePicker, year: Int,monthOfYear : Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                formattedDate = dateFormat.format(selectedDate.time)
                Tvdate.text= "Selected Date: " + formattedDate
            },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }


        var formattedTime=""
        timeSpin.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this, { _, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    selectedTime.set(Calendar.MINUTE, minute)
                    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                    formattedTime = timeFormat.format(selectedTime.time)
                    Tvtime.text = "Selected Time: $formattedTime"
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true // true untuk format 24 jam, false untuk AM/PM
            )
            timePickerDialog.show()
        }


        with(binding){
//            submitBtn.setOnClickListener {
//                val intent = Intent(this@activity_third, activity_four::class.java)
//                intent.getStringExtra("selectedFrom")
//                intent.getStringExtra("selectedTo")
//                startActivity(intent)
//            }

            submitBtn.setOnClickListener{
                val airline = intent.getStringExtra("selectedAirline")
                val class1 = intent.getStringExtra("selectedClass")
                val airlinemain2 = intent.getStringExtra("fromMain")
                val classmain2 = intent.getStringExtra("toMain")
                Toast.makeText(this@activity_third, "Maskapai anda: " + airline.toString() + "\n" + "Tiket anda: " + class1.toString()  ,Toast.LENGTH_LONG).show()
                Toast.makeText(this@activity_third, "Hari keberangkatan: " + formattedDate + "\n" +  "Jam keberangkatan: " + formattedTime ,Toast.LENGTH_LONG).show()
            }


            resetBtn.setOnClickListener{
                val intent = Intent(this@activity_third, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}