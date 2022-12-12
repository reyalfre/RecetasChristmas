package com.example.recetasexamen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recetasexamen.model.Receta

@Database(entities = [Receta::class], version = 1)
abstract class RecetaDatabase : RoomDatabase() {
    abstract fun recetaDao(): RecetaDatabase  //configurar el Dao
}
