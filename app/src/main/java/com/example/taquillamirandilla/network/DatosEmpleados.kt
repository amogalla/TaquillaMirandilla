package com.example.taquillamirandilla.network

import com.squareup.moshi.Json

data class DatosEmpleados(
    @Json(name = "id") val id: String,
    val name: String,
    val email: String)