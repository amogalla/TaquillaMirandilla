package com.example.taquillamirandilla.finalizar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taquillamirandilla.database.EntradaDatabaseDao

class FinalizarViewModel(
    val database: EntradaDatabaseDao,
    application: Application): AndroidViewModel(application) {
}