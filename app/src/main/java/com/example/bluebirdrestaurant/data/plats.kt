package com.example.bluebirdrestaurant.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plats")
data class plats(

    @PrimaryKey
    var id: Long = 0L,

    @ColumnInfo(name = "Nom_plat")
    var nom_plat: String = "",

    @ColumnInfo(name = "Descripcio")
    var descripcio: String = "",

    @ColumnInfo(name = "Tipus")
    var tipus: String ="",

    @ColumnInfo(name = "Preu")
    var preu: Double =0.0,

    ){
    fun totsElsPlats(): Array<plats>? {
        return arrayOf<plats>(
            //begudes
            plats(1, "Taronjada", "Taronjada casera feta cada matí", "beguda", 2.00),
            plats(2, "Fanta de llimona", "Llimonada amb gas", "beguda", 2.30),
            plats(3, "Aigua", "Aigua mineral", "beguda", 1.30),

            //entrepans
            plats(4, "Borico", "Entrepa calent de bacon, formatge, llom i ceba", "entrepa", 4.30),
            plats(5, "Fuet", "Entrepa fred de fuet amb tomaquet", "entrepa", 2.30),
            plats(6, "Vikini", "Sandwich calent de formatge i pernil dolç", "entrepa", 2.10),

            //postres
            plats(7, "Coulant de Ferrero", "Coulant de chocolata amb centre de Ferrero", "postre", 4.10),
            plats(8, "Profiterols", "Profiterols de nata amb xocolata calenta per sobre", "postre", 3.50),
            plats(9, "Gelat", "Gelat de vainilla, xocolata i maduixa", "postre", 1.10),
        )


    }




}