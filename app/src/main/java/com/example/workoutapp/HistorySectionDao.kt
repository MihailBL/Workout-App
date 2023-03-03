package com.example.workoutapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistorySectionDao {

    // Insert object in the database
    @Insert
    suspend fun insert(historyEntity: HistorySectionEntity)

    // Delete object from database
    @Delete
    suspend fun delete(historyEntity: HistorySectionEntity)

    // Get all elements from database
    /** IF THE RETURNED TYPE OF A FUNCTION IS COROUTINE.FLOW THEN WE MUST NOT USE SUSPEND MODIFIER!! */
    @Query("SELECT * FROM 'history-table'")
    suspend fun getAllDatesForCompletedExercises() : List<HistorySectionEntity>
}