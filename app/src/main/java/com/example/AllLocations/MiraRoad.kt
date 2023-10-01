package com.example.AllLocations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.NearbyTurfs.*
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.miraroad.*
//import kotlinx.android.synthetic.main.turfs1.*
//import kotlinx.android.synthetic.main.turfs1.turf6_btn

class MiraRoad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.miraroad)

        val turf6_btn = findViewById<Button>(R.id.turf6_btn)
        val turf8_btn = findViewById<Button>(R.id.turf8_btn)
        val turf9_btn = findViewById<Button>(R.id.turf9_btn)
        val turf11_btn = findViewById<Button>(R.id.turf11_btn)

        turf6_btn.setOnClickListener{
            val intent = Intent(this, Turfit::class.java)
            startActivity(intent)
        }

        turf8_btn.setOnClickListener{
            val intent = Intent(this, Dugout::class.java)
            startActivity(intent)
        }

        turf9_btn.setOnClickListener{
            val intent = Intent(this, PgVora::class.java)
            startActivity(intent)
        }

        turf11_btn.setOnClickListener{
            val intent = Intent(this, StXaviers::class.java)
            startActivity(intent)
        }
    }
}