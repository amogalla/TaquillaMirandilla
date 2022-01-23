package com.example.android.trackmysleepquality.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entrada_table")
data class Entrada(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,

        @ColumnInfo(name = "grada")
        var grada: String = "",

        @ColumnInfo(name = "fila")
        var fila: Int = 0,

        @ColumnInfo(name = "asiento")
        var asiento: Int = 0,

        @ColumnInfo(name = "partido")
        val partido: String = "",
)
