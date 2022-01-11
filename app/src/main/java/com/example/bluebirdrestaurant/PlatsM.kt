package com.example.bluebirdrestaurant
import androidx.lifecycle.ViewModel

class PlatsM() : ViewModel() {

    public var primerPlat : String =""
    public var segonPlat : String =""
    public var postres : String =""


    fun primerplatSeleccionat(plat: String) {
        primerPlat = plat
    }

    fun segonplatSeleccionat(plat: String) {
        segonPlat = plat
    }

    fun postreSeleccionat(plat: String) {
        postres = plat
    }

}

