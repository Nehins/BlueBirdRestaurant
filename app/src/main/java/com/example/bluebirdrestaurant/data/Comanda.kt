package com.example.bluebirdrestaurant.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comanda")
data class Comanda(

    @PrimaryKey(autoGenerate = true)
    var ID: Long = 0L,

    @ColumnInfo(name = "Correu_client")
    val correu_client: String,

    @ColumnInfo(name = "Nom_beguda")
    val nom_beguda: String,

    @ColumnInfo(name = "Nom_entrepa")
    var nom_entrepa: String,

    @ColumnInfo(name = "Nom_postre")
    var nom_postre: String,

    @ColumnInfo(name = "Preu_total")
    var preu_total: Double
)