package com.example.gamebooth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailsActivity : AppCompatActivity() {

    lateinit var pay: Button
    lateinit var done: Button
    lateinit var county: EditText
    lateinit var street: EditText
    lateinit var hse: EditText
    lateinit var week1: CheckBox
    lateinit var week2: CheckBox
    lateinit var month1: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        county = findViewById(R.id.county)
        street = findViewById(R.id.street)
        hse = findViewById(R.id.house)
        done = findViewById(R.id.done)
        pay = findViewById(R.id.pay)

        week1 = findViewById(R.id.week1)
        week2 = findViewById(R.id.week2)
        month1 = findViewById(R.id.month1)

        week1.setOnClickListener { onCheckboxClicked(week1) }
        week2.setOnClickListener { onCheckboxClicked(week2) }
        month1.setOnClickListener { onCheckboxClicked(month1) }


        done.setOnClickListener {

            val county = county.text.toString().trim()
            val street = street.text.toString().trim()
            val house = hse.text.toString().trim()

            if (county.isNotEmpty() && street.isNotEmpty() && house.isNotEmpty()){
                Toast.makeText(applicationContext, "Your order has been processed", Toast.LENGTH_LONG)
                    .show()
                var web1 = Intent(this, MainActivity::class.java)
                startActivity(web1)

            }else{
                Toast.makeText(this,"Please enter required details", Toast.LENGTH_SHORT).show()
            }

        }

        //Pay page
        pay.setOnClickListener {
            val county = county.text.toString().trim()
            val street = street.text.toString().trim()
            val house = hse.text.toString().trim()

            if (county.isNotEmpty() && street.isNotEmpty() && house.isNotEmpty()){
                val simToolKitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { startActivity(it) }
            }else{
                Toast.makeText(this,"Please enter required details", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun onCheckboxClicked(clickedCheckbox: CheckBox) {
        if (clickedCheckbox == week1) {
            week2.isChecked = false
            month1.isChecked = false
        } else if (clickedCheckbox == week2) {
            week1.isChecked = false
            month1.isChecked = false
        } else if (clickedCheckbox == month1) {
            week1.isChecked = false
            week2.isChecked = false
        }
        val selectedValue = clickedCheckbox.text.toString()
        Toast.makeText(this, "Selected duration: $selectedValue", Toast.LENGTH_SHORT).show()
    }
}
