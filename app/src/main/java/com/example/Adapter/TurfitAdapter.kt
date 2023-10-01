package com.example.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreen.R
import com.example.splashscreen.R.*


class TurfitAdapter( var context:Context) : RecyclerView.Adapter<TurfitAdapter.MyViewHolder>() {

    var color_icon_matrix = arrayOf <IntArray>(
        intArrayOf(android.R.color.holo_red_dark, drawable.turfit1),
        intArrayOf (android.R.color.holo_blue_dark, R.drawable.turfitup),
        intArrayOf(android.R.color.holo_green_dark, R.drawable.turfitup2),
        intArrayOf(android.R.color.holo_orange_dark, R.drawable.turfitup3)
    )

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var img_view: ImageView
        lateinit var container : RelativeLayout
        init{
            img_view = itemView.findViewById(id.img_view) as ImageView
            container = itemView.findViewById(id.turfit_container) as RelativeLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(layout.turfitup_layout_page,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img_view.setImageResource(color_icon_matrix[position][1])
        holder.container.setBackgroundResource(color_icon_matrix[position][0])
    }

    override fun getItemCount(): Int {
        return color_icon_matrix.size
    }
}