package com.example.workoutapp;

import java.lang.System;

/**
 * WE MUST ADD THIS CLASS IN THE ANDROID MANIFEST IN 'Application tag' -> 'android:name=' !!!
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/workoutapp/WorkoutApp;", "Landroid/app/Application;", "()V", "databaseInstance", "Lkotlin/Lazy;", "Lcom/example/workoutapp/HistorySectionDatabase;", "getDatabaseInstance", "()Lkotlin/Lazy;", "app_debug"})
public final class WorkoutApp extends android.app.Application {
    
    /**
     * GET INSTANCE OF THE DATABASE WITH LAZY METHOD WHICH MEANS ONLY WHEN WE ASK FOR IT
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<com.example.workoutapp.HistorySectionDatabase> databaseInstance = null;
    
    public WorkoutApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Lazy<com.example.workoutapp.HistorySectionDatabase> getDatabaseInstance() {
        return null;
    }
}