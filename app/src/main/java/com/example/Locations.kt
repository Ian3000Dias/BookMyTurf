package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.AllLocations.Bandra
import com.example.AllLocations.Bhayandar
import com.example.AllLocations.MiraRoad
import com.example.AllLocations.Santacruz1
import com.example.NearbyTurfs.Sporting
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.locations.*
//import kotlinx.android.synthetic.main.turfs1.*

class Locations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.locations)

        val btnBandra = findViewById<Button>(R.id.btnBandra)
        val btnMiraroad = findViewById<Button>(R.id.btnMiraroad)
        val btnSantacruz = findViewById<Button>(R.id.btnSantacruz)
        val btnBhayandhar = findViewById<Button>(R.id.btnBhayandhar)

        btnBandra.setOnClickListener {
            val intent = Intent(this, Bandra::class.java)
            startActivity(intent)
        }
        btnSantacruz.setOnClickListener {
            val intent = Intent(this, Santacruz1::class.java)
            startActivity(intent)
        }
        btnMiraroad.setOnClickListener {
            val intent = Intent(this, MiraRoad::class.java)
            startActivity(intent)
        }

        btnBhayandhar.setOnClickListener {
            val intent = Intent(this, Bhayandar::class.java)
            startActivity(intent)
        }
    }
}