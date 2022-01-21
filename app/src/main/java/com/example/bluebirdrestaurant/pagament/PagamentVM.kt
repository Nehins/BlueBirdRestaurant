package com.example.bluebirdrestaurant.pagament

import androidx.lifecycle.ViewModel

class PagamentVM : ViewModel(){

    var nom_beguda = ""
    var nom_entrepa = ""
    var nom_postre = ""

    var preu_beguda = 0.0
    var preu_entrepa = 0.0
    var preu_postre = 0.0

    var correuUsuariLogIn = ""

    fun getNomBeguda():String{ return nom_beguda }

    fun getNomEntrepa():String{ return nom_entrepa }

    fun getNomPostre():String{ return nom_postre }

    fun getPreuBeguda():Double{ return preu_beguda }

    fun getPreuEntrepa():Double{ return preu_entrepa }

    fun getPreuPostre():Double{ return preu_postre }

    fun getCorreu():String{return correuUsuariLogIn}


    fun setNomBeguda(beguda : String){ nom_beguda = beguda}

    fun setNomEntrepa(entrepa : String){ nom_entrepa = entrepa }

    fun setNomPostre(postre : String){ nom_postre = postre}

    fun setPreuBeguda(beguda :Double){ preu_beguda = beguda }

    fun setPreuEntrepa(entrepa :Double){ preu_entrepa = entrepa }

    fun setPreuPostre(postre :Double){ preu_postre = postre }

    fun setCorreu(correu : String){correuUsuariLogIn = correu}





}