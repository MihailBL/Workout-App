package com.example.workoutapp

class ExerciseModel(private var id: Int,
                    private var exerciseName: String,
                    private var image: Int,
                    private var isCompleted: Boolean,
                    private var isSelected: Boolean){

    // Getters and Setters
    fun getId(): Int{
        return this.id
    }

    fun setId(newId: Int){
        this.id = newId
    }

    fun getExerciseName(): String{
        return this.exerciseName
    }

    fun setExerciseName(newExerciseName: String){
        this.exerciseName = newExerciseName
    }

    fun getImage(): Int{
        return this.image
    }

    fun setImage(newImage: Int){
        this.image = newImage
    }

    fun getIsCompleted(): Boolean{
        return this.isCompleted
    }

    fun setIsCompleted(isCompleted: Boolean){
        this.isCompleted = isCompleted
    }

    fun getIsSelected(): Boolean{
        return this.isSelected
    }

    fun setIsSelected(isSelected: Boolean){
        this.isSelected = isSelected
    }
}