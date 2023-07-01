package com.example.gamebooth

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.coroutines.NonCancellable.cancel

class MainActivity : AppCompatActivity() {
    lateinit var PS5: CardView
    lateinit var PS4: CardView
    lateinit var PS3: CardView
    lateinit var xbox: CardView
    lateinit var nintendo: CardView
    lateinit var PC: CardView
    lateinit var about: CardView
    lateinit var logout: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PS5 = findViewById(R.id.cardPS5)
        PS4 = findViewById(R.id.cardPS4)
        PS3 = findViewById(R.id.cardPS3)
        PC = findViewById(R.id.cardPC)
        nintendo = findViewById(R.id.cardNintendo)
        xbox = findViewById(R.id.cardXbox)
        about = findViewById(R.id.About)
        logout = findViewById(R.id.Logout)

        PS5.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked PS5", Toast.LENGTH_SHORT).show()
            var web1 = Intent(this, PS5Activity::class.java)
            startActivity(web1)

        }

        PS4.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked PS4", Toast.LENGTH_SHORT).show()
            var web = Intent(this, PS4Activity::class.java)
            startActivity(web)
        }

        PS3.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked PS3", Toast.LENGTH_SHORT).show()
            var list = Intent(this, PS3Activity::class.java)
            startActivity(list)
        }

        PC.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked PC", Toast.LENGTH_SHORT).show()
            var tool = Intent(this, PCActivity::class.java)
            startActivity(tool)
        }

        nintendo.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked Nintendo ", Toast.LENGTH_SHORT)
                .show()
            var text = Intent(this, NintendoActivity::class.java)
            startActivity(text)
        }

        xbox.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked Xbox ", Toast.LENGTH_SHORT).show()
            var text = Intent(this, XboxActivity::class.java)
            startActivity(text)
        }

        about.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked About ", Toast.LENGTH_SHORT).show()
            var text = Intent(this, AboutActivity::class.java)
            startActivity(text)
        }


        logout.setOnClickListener {
            Toast.makeText(applicationContext, "You have clicked logout", Toast.LENGTH_SHORT).show()

            var box = AlertDialog.Builder(this)
            box.setMessage("Do you want to close this application?")
            box.setPositiveButton(
                "Proceed",
                DialogInterface.OnClickListener { dialog, id -> finish() })
            box.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialog, id -> cancel() })

            var alert = box.create()
            alert.setTitle("Gamebooth")
            alert.show()
        }
    }
}