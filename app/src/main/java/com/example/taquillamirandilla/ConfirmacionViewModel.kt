package com.example.taquillamirandilla

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class ConfirmacionViewModel: ViewModel() {

    var codigoEntrada = "test"

    lateinit var listaCodigos: MutableList<String>

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
        listaCodigos = mutableListOf("0B6YG", "WP7U1", "R5T9M", "JQY3V", "4FH61")
        listaCodigos.shuffle()
        listaCodigos = mutableListOf(listaCodigos[0]) //Nos quedamos sólo con un partido de forma aleatoria
    }

    private fun partidoAleatorio(){
        if (listaCodigos.isEmpty())
            //localidadTermina()
        else
            codigoEntrada = listaCodigos[0]
    }

}