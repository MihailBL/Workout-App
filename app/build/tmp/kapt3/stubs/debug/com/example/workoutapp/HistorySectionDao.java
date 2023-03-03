package com.example.workoutapp;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/workoutapp/HistorySectionDao;", "", "delete", "", "historyEntity", "Lcom/example/workoutapp/HistorySectionEntity;", "(Lcom/example/workoutapp/HistorySectionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDatesForCompletedExercises", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
public abstract interface HistorySectionDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.workoutapp.HistorySectionEntity historyEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.workoutapp.HistorySectionEntity historyEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    /**
     * IF THE RETURNED TYPE OF A FUNCTION IS COROUTINE.FLOW THEN WE MUST NOT USE SUSPEND MODIFIER!!
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM \'history-table\'")
    public abstract java.lang.Object getAllDatesForCompletedExercises(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workoutapp.HistorySectionEntity>> continuation);
}