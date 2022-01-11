package com.example.bluebirdrestaurant.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuaris")
data class User(

    @PrimaryKey(autoGenerate = true)
    var ID: Long = 0L,

    @ColumnInfo(name = "Correu")
    val correu: String,

    @ColumnInfo(name = "Nom")
    val nom: String,

    @ColumnInfo(name = "Contrasenya")
    var contrasenya: String

)