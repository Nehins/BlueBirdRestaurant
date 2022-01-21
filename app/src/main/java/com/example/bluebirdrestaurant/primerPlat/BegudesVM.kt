package com.example.bluebirdrestaurant.primerPlat
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.plats
import kotlinx.coroutines.launch

class BegudesVM (val database : BlueBirdDao, application: Application) : ViewModel(){

    internal val llistaBegudes : List<plats> = database.mostrarBegudes()

}
