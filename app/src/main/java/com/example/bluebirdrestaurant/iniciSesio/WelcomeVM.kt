package com.example.bluebirdrestaurant.iniciSesio

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluebirdrestaurant.Recursos.Prefs
import com.example.bluebirdrestaurant.Recursos.SharedApp
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.User
import com.example.bluebirdrestaurant.data.plats
import kotlinx.coroutines.launch


class WelcomeVM (val database : BlueBirdDao, application: Application) : ViewModel(){

    suspend fun registrarPlats (){

        var plats = plats()
        database.insertAll(plats.totsElsPlats()!!)
    }

    public fun creacioDePlats(){
        viewModelScope.launch {
            registrarPlats()
        }
    }


    public fun comprobarUsuari(correu : String, pass : String):String{
        if(pass==database.usuariregistrat(correu)){
            SharedApp.prefs.nomUsuari = database.usuariNom(correu)
            return "ok"
        }

        return "ko"
    }

}