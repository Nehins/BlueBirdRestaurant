package com.example.bluebirdrestaurant.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlueBirdDao {

    @Insert suspend fun addUser(user: User)

    @Query("SELECT * FROM usuaris ORDER BY correu ASC")
    fun readAllData(): List<User>
}