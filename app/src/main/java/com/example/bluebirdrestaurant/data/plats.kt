package com.example.bluebirdrestaurant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plats")
data class plats(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nom_plat: String,
    val tipus: String,
    val preu: Double

    )