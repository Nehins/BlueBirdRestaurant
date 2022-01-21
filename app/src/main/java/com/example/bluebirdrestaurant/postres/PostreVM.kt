package com.example.bluebirdrestaurant.postres

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.Comanda
import com.example.bluebirdrestaurant.data.plats

class PostreVM (val database : BlueBirdDao, application: Application) : ViewModel(){

    internal val llistaPostres: List<plats> = database.mostrarPostres()


}
