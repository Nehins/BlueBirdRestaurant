package com.example.bluebirdrestaurant.segonPlat

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.plats

class SegonPlatVM (val database : BlueBirdDao, application: Application) : ViewModel(){

    internal val llistaSegons : List<plats> = database.mostrarEntrepans()

}
