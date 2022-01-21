package com.example.bluebirdrestaurant.Recursos

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {

    val PREFS_NAME = "com.bluebirdrestaurant.sharedpreferences"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)


    var SHARED_USUARI = ""
    var nomUsuari: String
        get() = prefs.getString(SHARED_USUARI, "")!!
        set(value) = prefs.edit().putString(SHARED_USUARI, value).apply()



}

