package com.example.bluebirdrestaurant.segonPlat

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.primerPlat.BegudesVM

class SegonPlatVMFactory (private val dataSource: BlueBirdDao,
                          private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SegonPlatVM::class.java)) {
            return SegonPlatVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}