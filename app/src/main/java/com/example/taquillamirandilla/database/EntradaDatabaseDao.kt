package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EntradaDatabaseDao {

    @Insert
    suspend fun insert(night: Entrada)

    @Update
    suspend fun update(night: Entrada)

    @Query("SELECT * from entrada_table WHERE id = :key")
    suspend fun get(key: Long): Entrada?

    @Query("DELETE FROM entrada_table")
    suspend fun clear()

    @Query("SELECT * FROM entrada_table ORDER BY id DESC")
    fun getTodasLasEntradas(): LiveData<List<Entrada>>

    //@Query("SELECT * FROM entrada_table ORDER BY id DESC LIMIT 1")
    //suspend fun getUltimaEntrada(): Entrada?
}

