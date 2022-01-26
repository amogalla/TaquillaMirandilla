package com.example.taquillamirandilla

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class ConfirmacionViewModel: ViewModel() {

    var partido = "test"

    lateinit var listaPartidos: MutableList<String>

    init {
        resetList()
        partidoAleatorio()
        Log.i("ConfirmacionViewModel", "ConfirmacionViewModel creado con éxito.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ConfirmacionViewModel", "ConfirmacionViewModel destruido.")
    }

    private fun resetList(){
        listaPartidos = mutableListOf("1111", "2222", "3333", "4444")
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