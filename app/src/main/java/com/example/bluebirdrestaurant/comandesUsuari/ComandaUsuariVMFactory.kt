package com.example.bluebirdrestaurant.comandesUsuari

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao

class ComandaUsuariVMFactory (private val dataSource: BlueBirdDao,
                              private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ComandaUsuariVM::class.java)) {
            return ComandaUsuariVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}