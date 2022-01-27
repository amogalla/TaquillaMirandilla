package com.example.android.trackmysleepquality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entrada::class], version = 1, exportSchema = false)
abstract class EntradaDatabase : RoomDatabase() {


    abstract val entradaDatabaseDao: EntradaDatabaseDao //Conecta la base de datos al DAO.

    companion object {
        @Volatile
        private var INSTANCE: EntradaDatabase? = null

        fun getInstance(context: Context): EntradaDatabase {
            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a time.
            synchronized(this) {
                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            EntradaDatabase::class.java,
                            "entradas_history_database"
                    )
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            .fallbackToDestructiveMigration()
                            .build()

                    INSTANCE = instance
                }

                return instance  // smart cast to be non-null.
            }
        }
    }
}
