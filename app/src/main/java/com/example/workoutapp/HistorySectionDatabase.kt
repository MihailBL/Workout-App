package com.example.workoutapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** SETTING THIS ABSTRACT CLASS TO BE DATABASE BRIDGE*/
@Database(entities = [HistorySectionEntity::class], version = 1)
abstract class HistorySectionDatabase : RoomDatabase() {

    // get instance of the Dao interface
    abstract fun historySectionDao(): HistorySectionDao

    companion object{
        @Volatile
        private var INSTANCE: HistorySectionDatabase? = null

        fun getInstance(context: Context) : HistorySectionDatabase{
            // Allow only 1 thread at a time to execute this code
            synchronized(this){
                var tempInstance = INSTANCE
                if (tempInstance == null){
                    tempInstance = Room.databaseBuilder(context.applicationContext, HistorySectionDatabase::class.java, "history-table")
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = tempInstance
                }
                return tempInstance
            }
        }
    }
}