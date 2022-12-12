package com.example.recetasexamen.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recetasexamen.model.Receta

@Dao
interface RecetaDao {

    @Query("SELECT * FROM TABLA_RECETA")
    suspend fun getAllShopping(): MutableList<Receta>

    @Insert
    suspend fun insertShopping(receta: Receta)

    @Query("DELETE FROM tabla_receta WHERE id = :id")
    suspend fun deleteShopping(id: Int)

    @Update
    suspend fun updateReceta(receta: Receta)

    @Query("SELECT * FROM tabla_receta WHERE iscompleated")
    suspend fun getCompleatedReceta(): MutableList<Receta>

    @Query("SELECT * FROM tabla_receta WHERE NOT iscompleated")
    suspend fun getPendingShopping(): MutableList<Receta>
    /*@Query("SELECT * FROM tabla_receta")
    fun getAllReceta(): MutableList<Receta>

    @Query("SELECT * FROM tabla_receta WHERE id = :id")
    fun getRecetaById(id: Int): Receta

    @Insert
    fun addReceta(receta: Receta)

    @Update
    fun updateReceta(receta: Receta)

    @Query("DELETE FROM tabla_receta WHERE id= :id")
    fun deleteReceta(id: Int)*/

   /* @Query("SELECT * FROM tabla_receta WHERE iscompleted")
    fun getCompletedShopping(): MutableList<Receta>

    @Query("SELECT * FROM tabla_receta WHERE NOT iscompleated")
    suspend fun getPendingSHopping(): MutableList<Receta>*/
}