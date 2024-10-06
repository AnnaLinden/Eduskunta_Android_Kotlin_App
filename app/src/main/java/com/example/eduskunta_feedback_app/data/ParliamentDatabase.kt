package com.example.eduskunta_feedback_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eduskunta_feedback_app.data.model.MP
import com.example.eduskunta_feedback_app.data.model.MPComment

@Database(entities = [MP::class, MPComment::class], version = 1)
abstract class ParliamentDatabase: RoomDatabase()  {
    abstract fun mpDao(): MPDao
    abstract fun mpCommentDao(): MPCommentDao

    companion object {
        @Volatile
        private var INSTANCE: ParliamentDatabase? = null

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