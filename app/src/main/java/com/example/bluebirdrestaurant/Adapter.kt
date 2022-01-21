package com.example.bluebirdrestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.data.plats
import com.example.bluebirdrestaurant.pagament.PagamentVM

class Adapter(private val context: Context,
              private val list: List<plats>, private val pagament : PagamentVM
) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nomPlat: TextView = view.findViewById(R.id.nom)
        val descripcioPlat: TextView = view.findViewById(R.id.comandaBeguda)
        val preuplat: TextView = view.findViewById(R.id.preu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_view,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nomPlat.text = data.nom_plat
        holder.descripcioPlat.text = data.descripcio
        holder.preuplat.text = data.preu.toString()+" €"

        holder.itemView.setOnClickListener(){ view : View ->
            if(data.tipus=="beguda"){
                pagament.setPreuBeguda(data.preu)
                pagament.setNomBeguda(data.nom_plat)
                view.findNavController().navigate(R.id.action_begudes_to_segonPlat)
            }

            else if(data.tipus=="entrepa"){
                pagament.setPreuEntrepa(data.preu)
                pagament.setNomEntrepa(data.nom_plat)
                view.findNavController().navigate(R.id.action_segonPlat_to_postres)
            }

            else if(data.tipus=="postre"){
                pagament.setPreuPostre(data.preu)
                pagament.setNomPostre(data.nom_plat)
                view.findNavController().navigate(R.id.action_postres_to_pagament)
            }

        }

    }

}