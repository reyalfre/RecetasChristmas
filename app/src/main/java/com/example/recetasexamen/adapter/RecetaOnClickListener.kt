package com.example.recetasexamen.adapter

import com.example.recetasexamen.model.Receta

interface RecetaOnClickListener {
    fun onCompleatedReceta(receta: Receta)
    fun onClickReceta(receta: Receta)
}