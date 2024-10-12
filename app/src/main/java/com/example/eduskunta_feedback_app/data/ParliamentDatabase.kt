package com.example.eduskunta_feedback_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eduskunta_feedback_app.data.model.MP
import com.example.eduskunta_feedback_app.data.model.MPComment

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Singleton class for creating and accessing the Room database instance.
@Database(entities = [MP::class, MPComment::class], version = 1)
abstract class ParliamentDatabase: RoomDatabase()  {
    // Provides access to MPDao
    abstract fun mpDao(): MPDao
    // Provides access to MPCommentDao
    abstract fun mpCommentDao(): MPCommentDao

    companion object {
        @Volatile
        private var INSTANCE: ParliamentDatabase? = null

        // Returns the singleton instance of the database
        fun getDatabase(context: Context): ParliamentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ParliamentDatabase::class.java,
                    "parliament_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}