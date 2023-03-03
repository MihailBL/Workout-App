package com.example.workoutapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/workoutapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/workoutapp/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    
    /**
     * 'viewBinding' IS NEW WAY TO ACCESS AND INFLATE XML LAYOUT FILES!!! MUST BE IMPORTED IN THE GRADLE FIRST!
     *    WHEN SYNCHRONIZED IT AUTOMATICALLY CREATES SPECIAL CLASSES FOR EACH XML LAYOUT FROM WHICH WE -->
     *    --> CAN GET REFERENCE TO A BINDING OBJECT!! THE BINDING OBJECT REPRESENTS THE WHOLE LAYOUT!!!
     *    EX.: 'activity_main' <-> SPECIAL CLASS <-> ActivityMainBinding... AND SO ON FOR EACH XML LAYOUT!
     */
    private com.example.workoutapp.databinding.ActivityMainBinding binding;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * NOTE: RESET BINDING OBJECT TO NULL WHEN CLOSING THIS ACTIVITY TO AVOID MEMORY LEAKS!!!
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
}