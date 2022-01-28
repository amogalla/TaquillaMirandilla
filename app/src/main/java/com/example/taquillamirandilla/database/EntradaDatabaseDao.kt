package com.example.taquillamirandilla.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EntradaDatabaseDao {

    @Insert
    suspend fun insert(entrada: Entrada)

    @Update
    suspend fun update(entrada: Entrada)

    @Query("DELETE FROM entrada_table")
    suspend fun clear()

    @Query("SELECT * from entrada_table WHERE id = :key")
    suspend fun get(key: Long): Entrada?

    @Query("SELECT * FROM entrada_table ORDER BY id DESC")
    fun getTodasLasEntradas(): LiveData<List<Entrada>>

    @Query("SELECT * FROM entrada_table ORDER BY id DESC LIMIT 1")
    suspend fun getUltimaEntrada(): Entrada?

}

