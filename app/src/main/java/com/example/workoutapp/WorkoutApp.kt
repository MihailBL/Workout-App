package com.example.workoutapp

import android.app.Application

/** WE MUST ADD THIS CLASS IN THE ANDROID MANIFEST IN 'Application tag' -> 'android:name=' !!! */
class WorkoutApp: Application() {
    /** CLASS THAT INHERITS 'Application()' WILL EXECUTES ALWAYS FIRST BEFORE ANYTHING ELSE!!! */
    val databaseInstance = lazy {
        HistorySectionDatabase.getInstance(this)
    }
}