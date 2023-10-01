package com.example

import android.content.Intent
import android.content.Intent.getIntentOld
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.appcheck.internal.util.Logger.TAG
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.json.JSONObject
import com.razorpay.PaymentResultListener
import com.razorpay.Checkout
//import kotlinx.android.synthetic.main.payment.*

class PaymentGateway1 : AppCompatActivity(), PaymentResultListener {

    private lateinit var fAuth: FirebaseAuth

    val db = Firebase.firestore

    lateinit var txtPaymentStatus: TextView

    lateinit var editAmount: EditText

    lateinit var btnPayNow: Button

    lateinit var a : TextView

    lateinit var b : TextView

    lateinit var c : TextView

//    val profileName= intent.getStringExtra("Turfname")



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.payment)

        txtPaymentStatus = findViewById(R.id.paymentStatus)

        editAmount = findViewById(R.id.edit_amount)

        btnPayNow = findViewById(R.id.btn_pay)

        a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)

        val Turf= intent.getStringExtra("Turf_Name").toString()

        val date_time = intent.getStringExtra("Date_Time").toString()

        val price = intent.getStringExtra("Price").toString()

        a.text = Turf

        b.text = date_time

        c.text = price



        btnPayNow.setOnClickListener {

            savePayments(editAmount.text.toString().trim().toInt())

        }



        Checkout.preload(this)

    }



    private fun savePayments(amount: Int) {

        val checkout = Checkout()

        checkout.setKeyID("rzp_test_lnnafEGB3BTpLh")

        try {

            val options = JSONObject()

            options.put("name", "Razorpay Gateway")

            options.put("description", "Enter Amount Below")

            //options.put("image","")

            options.put("theme.color", "#3399cc")

            options.put("currency", "INR")

            options.put("amount", amount * 100)



            val retryObj = JSONObject()

            retryObj.put("enabled", true)

            retryObj.put("max_count", 4)

            options.put("retry", retryObj)



            checkout.open(this, options)

        } catch (e: Exception) {

            Toast.makeText(this, "Error in Payment : " + e.message, Toast.LENGTH_LONG)

                .show()

            e.printStackTrace()

        }

    }



    override fun onPaymentSuccess(p0: String?) {

        txtPaymentStatus.text = "Payment Successfull"

        txtPaymentStatus.setTextColor(Color.GREEN)

        val Turf= intent.getStringExtra("Turf_Name").toString()

        val date_time = intent.getStringExtra("Date_Time").toString()

        val price = intent.getStringExtra("Price").toString()

        fAuth = Firebase.auth

        val currentUser = fAuth.uid.toString()


        val Turfs = hashMapOf(
            "Name" to Turf,
            "Date and Time" to date_time,
            "Price" to price
        )
//        val map: MutableMap<String, String> = HashMap()
//        map["Name"] = Turf
//        map["Date"] = date_time
//        map["Price"] = price
//
////        val array: Array<Pair<String, String>> = map.toList().toTypedArray()
//
//        val Turfs = map

        db.collection("Past Bookings").document(currentUser).collection("Turfs").document(Turf)
            .set(Turfs)
            .addOnSuccessListener {
                Log.d(TAG, "Turf added")
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error adding document", exception)
        }
            }

    override fun onPaymentError(p0: Int, p1: String?) {

        txtPaymentStatus.text = "Payment Failed"

        txtPaymentStatus.setTextColor(Color.RED)

    }



}






