package com.example.bluebirdrestaurant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Comanda::class, plats::class], version = 1, exportSchema = false )
abstract class BlueBirdDatabase : RoomDatabase(){

    abstract val bluebirdDao : BlueBirdDao

    companion object{

        @Volatile
        private var INSTANCE: BlueBirdDatabase? = null

        fun getDatabase(context: Context): BlueBirdDatabase {
            var instance = INSTANCE
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BlueBirdDatabase::class.java,
                    "bluebird_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
            }
            return instance

        }
    }
}