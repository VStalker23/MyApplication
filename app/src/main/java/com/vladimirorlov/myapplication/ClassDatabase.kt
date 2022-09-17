package com.vladimirorlov.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class ClassDatabase : RoomDatabase() {

    abstract fun getNotesDao(): ClassDao

    companion object{
        fun getDatabase(context: Context):ClassDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ClassDatabase::class.java,
                "note_database"
            ).build()
        }
    }
}