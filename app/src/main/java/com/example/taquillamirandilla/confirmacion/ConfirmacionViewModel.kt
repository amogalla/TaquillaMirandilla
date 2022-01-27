package com.example.taquillamirandilla.confirmacion

import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfirmacionViewModel(partido:String, grada:String, codigo:String): ViewModel() {

    private val _codigoEntrada = MutableLiveData<String>()
    val codigoEntrada: LiveData<String>
        get() = _codigoEntrada

    lateinit var listaCodigos: MutableList<String>


    init {
        resetList()
        codigoAleatorio()
        _codigoEntrada.value = codigo
        Log.i("ConfirmacionViewModel", "ConfirmacionViewModel creado con éxito. El código de compra es el $codigo")
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

    private fun codigoAleatorio(){ //prueba borrar
        if (listaCodigos.isEmpty())
            //localidadTermina()
        else
            _codigoEntrada.value = listaCodigos[0]
    }


    fun onClickValidar(){
        resetList()
    }

}