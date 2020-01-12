package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectDate = Calendar.getInstance()
        val today = Calendar.getInstance()

        val datePicker = object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view : DatePicker, year : Int, month: Int, day: Int){

                selectDate.set(year, month, day)
                val dateFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(dateFormat, Locale.UK)

                val age =  today.get(Calendar.YEAR) - selectDate.get(Calendar.YEAR)

                txtAge.setText("Age: " + age.toString())

                var savings : Int

                if(age in 16..20)
                    savings = 5000
                else if(age in 21..25)
                    savings = 14000
                else if(age in 26..30)
                    savings = 29000
                else if(age in 31..35)
                    savings = 50000
                else if(age in 36..40)
                    savings = 78000
                else if(age in 41..45)
                    savings = 116000
                else if(age in 46..50)
                    savings = 165000
                else if (age in 51..55)
                    savings = 228000
                else
                    savings = 0

                txtTotal.text = "Min. Savings: " + savings.toString()
            }
        }

        bDate.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this, datePicker, selectDate.get(Calendar.YEAR), selectDate.get(
                Calendar.MONTH), selectDate.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}
