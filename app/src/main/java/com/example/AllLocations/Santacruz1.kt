package com.example.AllLocations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.NearbyTurfs.*
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.turfs1.*

class Santacruz1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.santacruz1)

        val turf4_btn = findViewById<Button>(R.id.turf4_btn)
        val turf5_btn = findViewById<Button>(R.id.turf5_btn)

        turf4_btn.setOnClickListener{
            val intent = Intent(this, Santacruz::class.java)
            startActivity(intent)
        }

        turf5_btn.setOnClickListener{
            val intent = Intent(this, Golds::class.java)
            startActivity(intent)
        }
    }
}