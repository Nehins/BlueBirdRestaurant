package com.example.bluebirdrestaurant.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.FtsOptions.Order


@Dao
interface BlueBirdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComanda(comanda : Comanda)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plats : Array<plats>)

    @Query("SELECT Contrasenya FROM usuaris where Correu= :name ")
    fun usuariregistrat(name : String): String

    @Query("SELECT nom FROM usuaris where Correu= :name ")
    fun usuariNom(name : String): String


    @Query("SELECT * FROM COMANDA where Correu_client= :name ")
    fun comandaUsuari(name : String) : List<Comanda>

    @Query("SELECT * FROM plats where tipus=\"beguda\"")
    fun mostrarBegudes(): List<plats>

    @Query("SELECT * FROM plats where tipus=\"entrepa\"")
    fun mostrarEntrepans(): List<plats>

    @Query("SELECT * FROM plats where tipus=\"postre\"")
    fun mostrarPostres(): List<plats>




}