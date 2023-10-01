package com.example.NearbyTurfs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.turfs1.*

class Turfs1:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.turfs1)
        val turf1_btn = findViewById<Button>(R.id.turf1_btn)
        val turf2_btn = findViewById<Button>(R.id.turf2_btn)
        val turf3_btn = findViewById<Button>(R.id.turf3_btn)
        val turf4_btn = findViewById<Button>(R.id.turf4_btn)
        val turf5_btn = findViewById<Button>(R.id.turf5_btn)
        val turf6_btn = findViewById<Button>(R.id.turf6_btn)
        turf1_btn.setOnClickListener {
            val intent = Intent(this, Sporting::class.java)
            startActivity(intent)
        }

        turf2_btn.setOnClickListener {
            val intent = Intent(this, Andrews::class.java)
            startActivity(intent)
        }

        turf3_btn.setOnClickListener {
            val intent = Intent(this, Josephs::class.java)
            startActivity(intent)
        }

        turf4_btn.setOnClickListener{
            val intent = Intent(this, Santacruz::class.java)
            startActivity(intent)
        }

        turf5_btn.setOnClickListener{
            val intent = Intent(this, Golds::class.java)
            startActivity(intent)
        }

        turf6_btn.setOnClickListener{
            val intent = Intent(this, Turfit::class.java)
            startActivity(intent)
        }


    }

}