package com.example.bluebirdrestaurant.comandesUsuari

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.data.Comanda

class ComandaUsuariAdapter(private val context: Context,
                                    private val list: List<Comanda>
) : RecyclerView.Adapter<ComandaUsuariAdapter.ViewHolder>()  {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val nomBeguda : TextView
        val nomEntrepa: TextView
        val nomPostre: TextView
        val preutotal: TextView


        init{
            nomBeguda = view.findViewById(R.id.comandaBeguda)
            nomEntrepa = view.findViewById(R.id.comandaEntrepa)
            nomPostre = view.findViewById(R.id.comandaPostre)
            preutotal = view.findViewById(R.id.comandaPreuTotal)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comanda_view,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nomBeguda.text = data.nom_beguda
        holder.nomEntrepa.text = data.nom_entrepa
        holder.nomPostre.text = data.nom_postre
        holder.preutotal.text = data.preu_total.toString()
    }


}