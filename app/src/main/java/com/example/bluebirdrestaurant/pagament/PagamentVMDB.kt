package com.example.bluebirdrestaurant.pagament

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluebirdrestaurant.data.BlueBirdDao
import com.example.bluebirdrestaurant.data.Comanda
import kotlinx.coroutines.launch

class PagamentVMDB(val database : BlueBirdDao, application: Application) : ViewModel(){

    suspend fun registrarComanda (comanda : Comanda){
        database.addComanda(comanda)
    }

    public fun insertComanda(correuUser : String, beguda : String, entrepa : String, postre : String, total : Double){
        viewModelScope.launch {
            var comanda =  Comanda(correu_client =correuUser, nom_beguda = beguda, nom_entrepa = entrepa, nom_postre = postre, preu_total = total )
            registrarComanda(comanda)
        }
    }

}