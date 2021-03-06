package com.example.taquillamirandilla.confirmacion


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ConfirmacionViewModelFactory(private val partido:String, private val grada:String, private val codigo:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConfirmacionViewModel::class.java))
            return ConfirmacionViewModel(partido, grada, codigo) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}