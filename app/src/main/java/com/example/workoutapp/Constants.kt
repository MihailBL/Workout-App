package com.example.workoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        // Create exercise - abdominal crunch
        val abdominalCrunches = ExerciseModel(1, "Abdominal Crunches", R.drawable.image_abdominal_crunch,
            false, false)
        exerciseList.add(abdominalCrunches)

        // Create exercise - arms crossover
        val armsCrossover = ExerciseModel(2, "Arms Crossover", R.drawable.image_arms_crossover,
            false, false)
        exerciseList.add(armsCrossover)

        // Create exercise - high knees running in place
        val highKneesRunningInPlace = ExerciseModel(3, "High Knees Running In Place",
            R.drawable.image_high_knees_running_in_place, false, false)
        exerciseList.add(highKneesRunningInPlace)

        // Create exercise - jumping racks
        val jumpingRacks = ExerciseModel(4, "Jumping Racks", R.drawable.image_jumping_jacks,
            false, false)
        exerciseList.add(jumpingRacks)

        // Create exercise - lunge
        val lunge = ExerciseModel(5, "Lunge", R.drawable.image_lunge,
            false, false)
        exerciseList.add(lunge)

        // Create exercise - plank
        val plank = ExerciseModel(6, "Plank", R.drawable.image_plank,
            false, false)
        exerciseList.add(plank)

        // Create exercise - push up
        val pushUps = ExerciseModel(7, "Push Ups", R.drawable.image_push_up,
            false, false)
        exerciseList.add(pushUps)

        // Create exercise - push up and rotation
        val pushUpRotation = ExerciseModel(8, "Push Up Rotation", R.drawable.image_push_up_and_rotation,
            false, false)
        exerciseList.add(pushUpRotation)

        // Create exercise - side plank
        val sidePlank = ExerciseModel(9, "Side Plank", R.drawable.image_side_plank,
            false, false)
        exerciseList.add(sidePlank)

        // Create exercise - squat
        val squat = ExerciseModel(10, "Squat", R.drawable.image_squat,
            false, false)
        exerciseList.add(squat)

        // Create exercise - step up onto chair
        val stepUpOntoChair = ExerciseModel(11, "Step Up Onto Chair", R.drawable.image_step_up_onto_chair,
            false, false)
        exerciseList.add(stepUpOntoChair)

        // Create exercise - triceps dip on chair
        val tricepsDipOnChair = ExerciseModel(12, "Triceps Dip On Chair", R.drawable.image_triceps_dip_on_chair,
            false, false)
        exerciseList.add(tricepsDipOnChair)

        // Create exercise - wall sit
        val wallSit = ExerciseModel(13, "Wall Sit", R.drawable.image_wall_sit,
            false, false)
        exerciseList.add(wallSit)

        return exerciseList
    }
}