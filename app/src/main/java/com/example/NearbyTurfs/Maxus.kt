package com.example.NearbyTurfs

//import kotlinx.android.synthetic.main.activity_main.*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.Adapter.MaxusAdapter
import com.example.PaymentGateway1
import com.example.splashscreen.R
//import kotlinx.android.synthetic.main.maxus.*
//import kotlinx.android.synthetic.main.maxus.book_btn
//import kotlinx.android.synthetic.main.pgvora.*

import java.util.*

class Maxus : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    lateinit var textView: TextView
    lateinit var button: Button
    var time = "Please select Date and Time"
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
//    var myHour: Int = 0
//    var myMinute: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maxus)
        //payment gateway
        val book_btn = findViewById<Button>(R.id.book_btn)
        val btn_map10 = findViewById<Button>(R.id.btn_map10)
        book_btn.setOnClickListener {
            val intent = Intent(this,PaymentGateway1::class.java)
            intent.putExtra("Turf_Name","Maxus Turf",)
            intent.putExtra("Date_Time",time)
            intent.putExtra("Price","1500")
            startActivity(intent)
        }

        btn_map10.setOnClickListener {
            val url = "https://goo.gl/maps/wh8pE4aLEVpMbwdP6"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        //viewpager
        init()

        //datepicker
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.btnPick)
        button.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this, this, year, month, day)
            datePickerDialog.show()


        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month+1
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            this, this, hour, minute,
            DateFormat.is24HourFormat(this)
        )
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        var myMinute = ""
        var myHour = ""
        if (minute<10){ myMinute = "0$minute" }
        else{myMinute = minute.toString()}
        if (hourOfDay<10){ myHour = "0$hourOfDay" }
        else{myHour = hourOfDay.toString()}
        textView.text =
            "Date: $myDay-$myMonth-$myYear\nTime: $myHour:$myMinute"
        time = "Date: $myDay-$myMonth-$myYear\n\nTime: $myHour:$myMinute"
    }


    private fun init(){

        val view_pager1 = findViewById<ViewPager2>(R.id.view_pager1)
        view_pager1.adapter = MaxusAdapter(this)
    }
}