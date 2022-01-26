package com.example.taquillamirandilla.confirmacion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfirmacionViewModel: ViewModel() {

    private val _codigoEntrada = MutableLiveData<String>()
    val codigoEntrada: LiveData<String>
        get() = _codigoEntrada

    lateinit var listaCodigos: MutableList<String>

    init {
        resetList()
        partidoAleatorio()
        _codigoEntrada.value = ""
        Log.i("ConfirmacionViewModel", "ConfirmacionViewModel creado con éxito.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ConfirmacionViewModel", "ConfirmacionViewModel destruido.")
    }

    /**
     * //Nos quedamos sólo con un partido de forma aleatoria
     */
    fun resetList(){
        listaCodigos = mutableListOf("0B6YG", "WP7U1", "R5T9M", "JQY3V", "4FH61", "1QB3L", "49CD2")
        listaCodigos.shuffle()

        _codigoEntrada.value = listaCodigos[0]
    }

    private fun partidoAleatorio(){ //prueba borrar
        if (listaCodigos.isEmpty())
            //localidadTermina()
        else
            _codigoEntrada.value = listaCodigos[0]
    }

}