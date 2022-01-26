package com.example.taquillamirandilla

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class LocalidadViewModel: ViewModel() {

    var partido = "Error"

    lateinit var listaPartidos: MutableList<String>

    init {
        resetList()
        partidoAleatorio()
        Log.i("LocalidadViewModel", "LocalidadViewModel creado con éxito.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("LocalidadViewModel", "LocalidadViewModel destruido.")
    }

    private fun resetList(){
        listaPartidos = mutableListOf("Cádiz - Jaén", "Cádiz - Puerto Real", "Cádiz - Barbate", "Cádiz - Tarifa")
        listaPartidos.shuffle()
        listaPartidos = mutableListOf(listaPartidos[0]) //Nos quedamos sólo con un partido de forma aleatoria
    }

    private fun partidoAleatorio(){
        if (listaPartidos.isEmpty())
            //localidadTermina()
        else
            partido = listaPartidos[0]
    }

}