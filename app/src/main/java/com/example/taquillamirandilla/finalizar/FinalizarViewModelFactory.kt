package com.example.taquillamirandilla.finalizar

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taquillamirandilla.database.EntradaDatabaseDao

class FinalizarViewModelFactory(
    private val dataSource: EntradaDatabaseDao,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FinalizarViewModel::class.java))
            return FinalizarViewModel(dataSource, application) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}