package com.example.bluebirdrestaurant.Recursos

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_NAME = "com.bluebirdrestaurant.sharedpreferences"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)


    //correu_client
    val SHARED_CORREU_USUARI = "correu_usuari"
    var correu_usuari: String
        get() = prefs.getString(SHARED_CORREU_USUARI, "").toString()
        set(value) = prefs.edit().putString(SHARED_CORREU_USUARI, value).apply()


    //primer plat
    val SHARED_PRIMER = "primerPlat"
    var primerPlat: String
        get() = prefs.getString(SHARED_PRIMER, "").toString()
        set(value) = prefs.edit().putString(SHARED_PRIMER, value).apply()

    //segon plat
    val SHARED_SEGON = "shared_segonPlat"
    var segonPlat: String
        get() = prefs.getString(SHARED_SEGON , "").toString()
        set(value) = prefs.edit().putString(SHARED_SEGON , value).apply()

    //postres
    val SHARED_POSTRES = "shared_segonPlat"
    var postresnom: String
        get() = prefs.getString(SHARED_POSTRES , "").toString()
        set(value) = prefs.edit().putString(SHARED_POSTRES, value).apply()

}