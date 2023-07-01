package com.example.gamebooth

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {
    lateinit var insta: ImageView
    lateinit var tweet: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        insta = findViewById(R.id.instagram)
        tweet = findViewById(R.id.twitter)

        insta.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gameb00th/"))
            startActivity(browserIntent)
        }

        tweet.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/relmxix"))
            startActivity(browserIntent)
        }

    }
}