package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.segundoparcial.R

class NombreAdapter(private val nombreList : List<String>) : RecyclerView.Adapter<NombreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  NombreViewHolder(layoutInflater.inflate(R.layout.intem_names, parent, false))
    }

    override fun getItemCount(): Int  = nombreList.size

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
        holder.render(nombreList[position])
    }


}