package com.example.recetasexamen.model
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabla_receta")
data class Receta(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var product: String,
    var category: String,
    var webUrl: String,
    var isCompleated: Boolean = false
):Parcelable
