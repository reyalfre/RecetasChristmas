package com.example.recetasexamen

import android.app.Application
import androidx.room.Room
import com.example.recetasexamen.database.RecetaDatabase

class RecetaApplication : Application() {
    //implementado el patron singleton para que se pueda acceder desde cualquier parte de la app

    // object = crear el objeto
    // companion = crear el singleton
    companion object {
        lateinit var database: RecetaDatabase
    }

    //sobre escribimos la creacion de la basedatos
    override fun onCreate() {
        super.onCreate()


        //construimos la database
        database = Room.databaseBuilder(
            this,
            RecetaDatabase::class.java,
            "StoreDatabase"
        )
            .build()
    }
}