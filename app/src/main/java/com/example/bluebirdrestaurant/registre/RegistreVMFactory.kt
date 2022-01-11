package com.example.bluebirdrestaurant.registre

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao

class RegistreVMFactory(private val dataSource: BlueBirdDao,
                        private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistreVM::class.java)) {
            return RegistreVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}