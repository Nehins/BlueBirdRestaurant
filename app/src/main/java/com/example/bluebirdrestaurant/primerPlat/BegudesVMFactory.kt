package com.example.bluebirdrestaurant.primerPlat

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.iniciSesio.WelcomeVM

class BegudesVMFactory (private val dataSource: BlueBirdDao,
                        private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BegudesVM::class.java)) {
            return BegudesVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}