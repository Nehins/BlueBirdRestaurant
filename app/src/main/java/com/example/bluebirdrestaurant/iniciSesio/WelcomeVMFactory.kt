package com.example.bluebirdrestaurant.iniciSesio

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao


class WelcomeVMFactory (private val dataSource: BlueBirdDao,
                        private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeVM::class.java)) {
            return WelcomeVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}