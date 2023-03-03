package com.example.workoutapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0003J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/workoutapp/ExerciseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "adapter", "Lcom/example/workoutapp/RecyclerViewExerciseStatusAdapter;", "binding", "Lcom/example/workoutapp/databinding/ActivityExerciseBinding;", "currentExercisePosition", "", "exerciseList", "Ljava/util/ArrayList;", "Lcom/example/workoutapp/ExerciseModel;", "Lkotlin/collections/ArrayList;", "exerciseProgress", "exerciseTimer", "Landroid/os/CountDownTimer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "restProgress", "restTimer", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "assignRecyclerviewAdapter", "", "customDialogForBackButton", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInit", "status", "setExerciseProgressBarTimer", "setRestProgressBarTimer", "setUpExerciseTimerView", "setUpRestTimerView", "speakOutText", "text", "", "app_debug"})
public final class ExerciseActivity extends androidx.appcompat.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {
    private com.example.workoutapp.databinding.ActivityExerciseBinding binding;
    private android.os.CountDownTimer restTimer;
    private int restProgress = 0;
    private android.os.CountDownTimer exerciseTimer;
    private int exerciseProgress = 0;
    private java.util.ArrayList<com.example.workoutapp.ExerciseModel> exerciseList;
    private int currentExercisePosition = -1;
    private android.speech.tts.TextToSpeech textToSpeech;
    private android.media.MediaPlayer mediaPlayer;
    private com.example.workoutapp.RecyclerViewExerciseStatusAdapter adapter;
    
    public ExerciseActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setRestProgressBarTimer() {
    }
    
    private final void setExerciseProgressBarTimer() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setUpRestTimerView() {
    }
    
    private final void setUpExerciseTimerView() {
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    private final void speakOutText(java.lang.String text) {
    }
    
    private final void assignRecyclerviewAdapter() {
    }
    
    private final void customDialogForBackButton() {
    }
    
    /**
     * NOTE: HANDLES ALL USER'S BACK-PRESSED EVENTS(FROM DEVICE NAVIGATION, FROM CUSTOM TOOLBAR ETC...)!
     */
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}