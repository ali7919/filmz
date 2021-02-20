package com.codersan.filmz.Models

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Movie::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun dao(): MovieDao


    //singleton
    companion object {

        private var instance: DataBase? = null

        fun get_instace(application: Application): DataBase {
            return instance ?: Room.databaseBuilder(application, DataBase::class.java, "movie_db")
                .fallbackToDestructiveMigration()
                .build()
        }




    }




}