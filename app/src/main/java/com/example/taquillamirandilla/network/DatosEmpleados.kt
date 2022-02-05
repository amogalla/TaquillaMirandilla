package com.example.taquillamirandilla.network

import com.squareup.moshi.Json

data class DatosEmpleados(
    @Json(name = "id") val id: String,
    @Json(name = "name") val nombre: String,
    val email: String,
    @Json(name = "phone") val telefono: String
)