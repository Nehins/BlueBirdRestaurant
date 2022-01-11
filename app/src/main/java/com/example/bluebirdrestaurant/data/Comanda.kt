package com.example.bluebirdrestaurant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comanda")
data class Comanda(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val id_Client: Int,
    val primerPlat: String,
    val segonPlat: String,
    val postres: String,
    val preu_total: Double

)