package com.example.AllLocations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.NearbyTurfs.Andrews
import com.example.NearbyTurfs.Josephs
import com.example.NearbyTurfs.Sporting
import com.example.NearbyTurfs.Urbansports
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.bandra.*
//import kotlinx.android.synthetic.main.turfs1.*
//import kotlinx.android.synthetic.main.turfs1.turf1_btn
//import kotlinx.android.synthetic.main.turfs1.turf2_btn
//import kotlinx.android.synthetic.main.turfs1.turf3_btn

class Bandra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bandra)

        val turf1_btn = findViewById<Button>(R.id.turf1_btn)
        val turf2_btn = findViewById<Button>(R.id.turf2_btn)
        val turf3_btn = findViewById<Button>(R.id.turf3_btn)
        val turf10_btn = findViewById<Button>(R.id.turf10_btn)

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

        turf10_btn.setOnClickListener {
            val intent = Intent(this, Urbansports::class.java)
            startActivity(intent)
        }
    }
}