package com.example.bluebirdrestaurant.registre

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.User
import kotlinx.coroutines.launch

class RegistreVM(val database : BlueBirdDao, application: Application) : ViewModel(){

     suspend fun registrarUsuari (user : User){
         database.addUser(user)
     }

    public fun insertNouUsuari(nomUser : String, correuUser : String, contra : String){
        viewModelScope.launch {
            var user =  User(correu=correuUser,
                nom=nomUser,
                contrasenya=contra)
            registrarUsuari(user)
        }
    }

}