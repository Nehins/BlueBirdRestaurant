package com.example.bluebirdrestaurant.comandesUsuari

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.Comanda
import com.example.bluebirdrestaurant.data.plats

class ComandaUsuariVM (val database : BlueBirdDao, application: Application) : ViewModel(){


    public fun mostrarComandes(usuari : String): List<Comanda> {
        val llistaPostres : List<Comanda> = database.comandaUsuari(usuari)
        return llistaPostres
    }


}
