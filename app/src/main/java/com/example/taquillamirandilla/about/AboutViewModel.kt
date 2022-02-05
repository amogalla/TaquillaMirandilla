package com.example.taquillamirandilla.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taquillamirandilla.network.EmpleadosApi
import kotlinx.coroutines.launch

class AboutViewModel : ViewModel() {

    private var _texto = MutableLiveData<String>()
    val texto: LiveData<String>
        get() = _texto

    private var n_taquillero: Int = 0

    init {
        getDatos()
    }

    private fun getDatos() {
        viewModelScope.launch {
            try {
                var listResult = EmpleadosApi.retrofitService.getProperties()
                n_taquillero = (0..listResult.size).random()
                _texto.value = "Si tiene alguna duda sobre cómo comprar entradas, por favor, " +
                        "escriba un correo a \n${listResult[n_taquillero].email}, o bien llame " +
                        "al ${listResult[n_taquillero].telefono}. \n\nContactará con " +
                        "${listResult[n_taquillero].nombre}.\n\nGracias."

            } catch (e: Exception) {
                _texto.value = "Se ha encontrado el siguiente error: ${e.message}"
            }
        }
    }
}