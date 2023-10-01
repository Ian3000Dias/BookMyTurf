package com.example

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.NearbyTurfs.Turfs1
import com.example.splashscreen.MainActivity
import com.example.splashscreen.R
import com.example.splashscreen.R.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import kotlinx.android.synthetic.main.activity_home_page.*
import android.widget.Button

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home_page)

        val button_popular = findViewById<Button>(R.id.button_popular)
        val button4 = findViewById<Button>(R.id.button4)
        val btn_logout = findViewById<Button>(R.id.btn_logout)


        button_popular.setOnClickListener{
            val i = Intent(this, Locations::class.java)
            startActivity(i)
        }
        button4.setOnClickListener {
            val url =
                "https://news.google.com/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRFp1ZEdvU0FtVnVHZ0pWVXlnQVAB?ceid=IN:en&oc=3"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        btn_logout.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            Firebase.auth.signOut()
        }

    }
}