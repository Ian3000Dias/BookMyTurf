package com.example.AllLocations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.NearbyTurfs.Maxus
import com.example.NearbyTurfs.Sporting
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.bayandar.*
//import kotlinx.android.synthetic.main.turfs1.*

class Bhayandar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bayandar)

        val turf7_btn = findViewById<Button>(R.id.turf7_btn)

        turf7_btn.setOnClickListener {
            val intent = Intent(this, Maxus::class.java)
            startActivity(intent)
        }
 }
}
