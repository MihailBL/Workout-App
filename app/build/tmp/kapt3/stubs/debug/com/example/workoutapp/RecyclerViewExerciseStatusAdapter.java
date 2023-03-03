package com.example.workoutapp;

import java.lang.System;

/**
 * BECAUSE WE ARE CREATING CUSTOM RECYCLER VIEW ADAPTER, WE MUST INHERIT FROM -->
 * --> 'RecyclerView.Adapter<VH>' CLASS
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/example/workoutapp/RecyclerViewExerciseStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/workoutapp/RecyclerViewExerciseStatusAdapter$ViewHolder;", "exerciseList", "Ljava/util/ArrayList;", "Lcom/example/workoutapp/ExerciseModel;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getExerciseList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class RecyclerViewExerciseStatusAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.workoutapp.RecyclerViewExerciseStatusAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.workoutapp.ExerciseModel> exerciseList = null;
    
    public RecyclerViewExerciseStatusAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.workoutapp.ExerciseModel> exerciseList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.workoutapp.ExerciseModel> getExerciseList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.workoutapp.RecyclerViewExerciseStatusAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.workoutapp.RecyclerViewExerciseStatusAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * BECAUSE WE'RE USING VIEW BINDING, WE NEED TO PASS OBJECT 'binding' INFLATED WITH CURRENT LAYOUT!!!
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/workoutapp/RecyclerViewExerciseStatusAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/workoutapp/databinding/RecyclerviewItemExerciseStatusBinding;", "(Lcom/example/workoutapp/RecyclerViewExerciseStatusAdapter;Lcom/example/workoutapp/databinding/RecyclerviewItemExerciseStatusBinding;)V", "tvItem", "Landroid/widget/TextView;", "getTvItem", "()Landroid/widget/TextView;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvItem = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.workoutapp.databinding.RecyclerviewItemExerciseStatusBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvItem() {
            return null;
        }
    }
}