package com.example.workoutapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/workoutapp/BMIActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/workoutapp/databinding/ActivityBmiactivityBinding;", "currentVisibleView", "", "calculateBMI", "", "view", "Landroid/view/View;", "checkUserInputForMetricUnits", "", "checkUserInputForUSUnits", "displayBMIResults", "bmiResults", "", "makeVisibleMetricUnitsView", "makeVisibleUSUnitsView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_debug"})
public final class BMIActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.workoutapp.BMIActivity.Companion Companion = null;
    private static final java.lang.String METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW";
    private static final java.lang.String US_UNITS_VIEW = "US_UNITS_VIEW";
    private com.example.workoutapp.databinding.ActivityBmiactivityBinding binding;
    private java.lang.String currentVisibleView = "METRIC_UNIT_VIEW";
    
    public BMIActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkUserInputForMetricUnits() {
        return false;
    }
    
    private final boolean checkUserInputForUSUnits() {
        return false;
    }
    
    private final void calculateBMI(android.view.View view) {
    }
    
    private final void displayBMIResults(float bmiResults) {
    }
    
    private final void makeVisibleMetricUnitsView() {
    }
    
    private final void makeVisibleUSUnitsView() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * CREATE COMPANION OBJECT:
     *    --> COMPANION OBJECTS ARE SINGLETON OBJECTS WHOSE PROPERTIES AND FUNCTIONS ARE TIED TO A CLASS -->
     *    --> BUT NOT TO THE INSTANCE OF THAT CLASS(CANNOT BE ACCESSED BY THE INSTANCES OF THE CLASS)!!!
     *    --> LIKE  STATIC KEYWORD IN JAVA!
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/workoutapp/BMIActivity$Companion;", "", "()V", "METRIC_UNITS_VIEW", "", "US_UNITS_VIEW", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}