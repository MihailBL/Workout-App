package com.example.workoutapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/workoutapp/HistoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/workoutapp/HistoryAdapter;", "binding", "Lcom/example/workoutapp/databinding/ActivityHistoryBinding;", "deleteCompletedExercise", "", "historySectionDao", "Lcom/example/workoutapp/HistorySectionDao;", "date", "", "getAllDatesOfCompletedExercises", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class HistoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.workoutapp.databinding.ActivityHistoryBinding binding;
    private com.example.workoutapp.HistoryAdapter adapter;
    
    public HistoryActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getAllDatesOfCompletedExercises(com.example.workoutapp.HistorySectionDao historySectionDao) {
    }
    
    /**
     * NOTE: IN 'getAllDatesOfCompletedExercises()' METHOD, WE DON'T GET THE LIST OF COMPLETED -->
     *       --> EXERCISES AS 'Flow<List<HistorySectionEntity>>' AND WE DON'T EXECUTE THE CODE IN -->
     *       --> '.collect{}' METHOD, WHICH AUTOMATICALLY UPDATES THE CHANGES TO THE DATABASE !!!
     */
    private final void deleteCompletedExercise(com.example.workoutapp.HistorySectionDao historySectionDao, java.lang.String date) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}