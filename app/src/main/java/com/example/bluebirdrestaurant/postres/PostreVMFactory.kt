package com.example.bluebirdrestaurant.postres

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bluebirdrestaurant.data.BlueBirdDao

class PostreVMFactory  (private val dataSource: BlueBirdDao,
                        private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostreVM::class.java)) {
            return PostreVM(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}