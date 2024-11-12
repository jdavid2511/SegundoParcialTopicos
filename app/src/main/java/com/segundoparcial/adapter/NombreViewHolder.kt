package com.example.myapplication.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.segundoparcial.R

class NombreViewHolder(view : View) :RecyclerView.ViewHolder(view ) {

    val tvNameList = view.findViewById<TextView>(R.id.tvNameItem);

    fun render(name :String){
        tvNameList.text = name
    }

}