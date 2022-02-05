package com.example.taquillamirandilla.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taquillamirandilla.network.EmpleadosApi
import kotlinx.coroutines.launch

class AboutViewModel : ViewModel() {

    private val _respuesta = MutableLiveData<String>()

    val respuesta: LiveData<String>
        get() = _respuesta


    init {
        getDatos()
    }

    private fun getDatos() {
        viewModelScope.launch {
            try {
                var listResult = EmpleadosApi.retrofitService.getProperties()
                _respuesta.value = "${listResult.size} datos leídos con éxito."
            } catch (e: Exception) {
                _respuesta.value = "Se ha encontrado el siguiente error: ${e.message}"
            }
        }
    }
}