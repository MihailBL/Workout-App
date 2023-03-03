package com.example.workoutapp

import androidx.room.Entity
import androidx.room.PrimaryKey

/** DATA CLASS SET AS ENTITY  */
@Entity(tableName = "history-table")
data class HistorySectionEntity(
    @PrimaryKey
    val date: String

)
