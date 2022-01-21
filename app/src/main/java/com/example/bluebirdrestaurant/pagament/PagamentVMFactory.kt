package com.example.bluebirdrestaurant.pagament

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.registre.RegistreVM

class PagamentVMFactory (private val dataSource: BlueBirdDao,
                         private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PagamentVMDB::class.java)) {
            return PagamentVMDB(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}