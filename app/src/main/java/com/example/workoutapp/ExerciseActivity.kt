package com.example.workoutapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityExerciseBinding
import com.example.workoutapp.databinding.CustomDialogBackConfirmationBinding
import java.util.Locale

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    // viewBinding object
    private var binding: ActivityExerciseBinding? = null

    // Create a timer for resting
    private var restTimer: CountDownTimer? = null
    // Create property for resting progress
    private var restProgress: Int = 0
    // Create timer for exercise and its progress
    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress: Int = 0

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition: Int = -1

    // Create Text To Speech
    private var textToSpeech: TextToSpeech? = null

    // Create MediaPlayer Object
    private var mediaPlayer: MediaPlayer? = null

    // Create adapter object from our custom adapter
    private var adapter: RecyclerViewExerciseStatusAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set up the binding object
        this.binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Get the exercise list from object-Constants
        this.exerciseList = Constants.defaultExerciseList()

        // Initialize Text-To-Speech
        this.textToSpeech = TextToSpeech(this, this)

        // THIS METHOD SETS A TOOLBAR TO ACT AS A ACTIONBAR
        setSupportActionBar(this.binding?.toolbarExerciseActivity)
        if (supportActionBar != null) {
            supportActionBar?.title = "WORKOUT APP"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        // TOOLBAR IS A TYPE OF NAVIGATION BAR
        this.binding?.toolbarExerciseActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        setUpRestTimerView()

        // Assign our adapter to the RecyclerView.adapter property
        assignRecyclerviewAdapter()
    }

    /** Method for setting The Rest Timer */
    private fun setRestProgressBarTimer(){
        this.binding?.progressBar?.progress = this.restProgress

        /** @param 'countDownInterval' : Every 1000 millis(USER SPECIFIED), the code in the curly brackets
         will be executed!!! */
        this.restTimer = object : CountDownTimer(15000, 1000){
            override fun onTick(remainingMillis: Long) {
                restProgress++
                binding?.progressBar?.progress = 15 - restProgress               // same as 'remainingMillis/1000'
                binding?.tvTimer?.text = (15 - restProgress).toString()          // same as 'remainingMillis/1000'

                if (binding?.progressBar?.progress == 2){
                    // Play Audio countdown sound
                    try {
                        // TODO: CAN BE WRITTEN IN A METHOD AND BE USABLE IN EXERCISE TIMER ALSO!
                        // Parse the string-location of the audio file into URI
                        val soundURI = Uri.parse("android.resource://com.example.workoutapp/" + R.raw.scountdown_sound)
                        mediaPlayer = MediaPlayer.create(this@ExerciseActivity, soundURI)
                        mediaPlayer?.isLooping = false
                        mediaPlayer?.start()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFinish() {
                // Load timer for the next exercise and increase exercise position
                currentExercisePosition++
                exerciseProgress = 0

                // Before loading the next exercise timer, set the current exercise as selected/current
                exerciseList!![currentExercisePosition].setIsSelected(true)
                adapter?.notifyDataSetChanged()                /** The adapter changes appearance based on the DATA MODEL! */

                setUpExerciseTimerView()
            }
        }.start()
    }

    /** Method for setting The Exercise Timer */
    private fun setExerciseProgressBarTimer(){
        this.binding?.progressBarExercise?.progress = exerciseProgress

        // TODO EXERCISE TIMER ORIGINALLY 50S
        this.exerciseTimer = object : CountDownTimer(50000, 1000){
            override fun onTick(remainingMillis: Long) {
                exerciseProgress++
                binding?.progressBarExercise?.progress = 50 - exerciseProgress
                binding?.tvExerciseTimer?.text = (50 - exerciseProgress).toString()
            }

            override fun onFinish() {
                // Before loading the rest timer, set the current exercise as completed and not selected
                exerciseList!![currentExercisePosition].setIsSelected(false)
                exerciseList!![currentExercisePosition].setIsCompleted(true)
                adapter?.notifyDataSetChanged()

                if (currentExercisePosition < exerciseList?.size!! - 1){
                    restProgress = 0
                    setUpRestTimerView()
                }else{
                    finish()
                    val intent = Intent(this@ExerciseActivity, FinishActivity::class.java)
                    startActivity(intent)
                }
            }
        }.start()
    }

    /** Method to set up  Rest Timer View */
    @SuppressLint("SetTextI18n")
    private fun setUpRestTimerView(){
        this.binding?.flGetReadyProgressBar?.visibility = View.VISIBLE
        this.binding?.flExerciseProgressBar?.visibility = View.GONE
        this.binding?.ivExerciseImage?.visibility = View.GONE
        this.binding?.tvExerciseTitle?.text = "Get Ready"
        // make upcoming exercises text visible
        this.binding?.tvNextExercise?.visibility = View.VISIBLE
        this.binding?.tvNextExerciseName?.visibility = View.VISIBLE

        // Set next exercise text
        if (this.currentExercisePosition + 1 <= this.exerciseList?.size!! - 1)
            this.binding?.tvNextExerciseName?.text = this.exerciseList?.get(this.currentExercisePosition+1)?.getExerciseName()
        else
            this.binding?.tvNextExerciseName?.text = "No Other Exercises"

        // Start Text-To-Speech here
        speakOutText("Rest Fifteen Seconds")

        setRestProgressBarTimer()
    }

    /**  Method to set up Exercise Timer */
    private fun setUpExerciseTimerView(){
        this.binding?.flGetReadyProgressBar?.visibility = View.GONE
        // make next exercise text gone
        this.binding?.tvNextExercise?.visibility = View.GONE
        this.binding?.tvNextExerciseName?.visibility = View.GONE
        this.binding?.ivExerciseImage?.visibility = View.VISIBLE
        this.binding?.flExerciseProgressBar?.visibility = View.VISIBLE

        val currentExercise = this.exerciseList?.get(this.currentExercisePosition)
        this.binding?.ivExerciseImage?.setImageResource(currentExercise?.getImage()!!)
        this.binding?.tvExerciseTitle?.text = currentExercise?.getExerciseName()

        // Start Text-To-Speech here
        speakOutText(this.exerciseList?.get(this.currentExercisePosition)?.getExerciseName()!!)

        setExerciseProgressBarTimer()
    }

    /** Initializer for Text-To-Speech */
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val result = this.textToSpeech?.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                Toast.makeText(this, "Language Not Supported!", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Text-To-Speech Object Initialized Successfully", Toast.LENGTH_LONG).show()
        }
    }

    /**  TextToSpeech -> speak the given text */
    private fun speakOutText(text: String){
        this.textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    /** Bind our custom adapter with the RecyclerView.adapter */
    private fun assignRecyclerviewAdapter(){
        this.adapter = RecyclerViewExerciseStatusAdapter(this.exerciseList!!)
        val rvExerciseStatus = this.binding?.rvExerciseStatus
        rvExerciseStatus?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExerciseStatus?.adapter = this.adapter
    }

    /** Custom Dialog for Back Pressed */
    private fun customDialogForBackButton(){
        val customDialog = Dialog(this)
        val customDialogBinding = CustomDialogBackConfirmationBinding.inflate(layoutInflater)

        customDialog.setContentView(customDialogBinding.root)
        customDialog.setCancelable(false)

        // Button Yes
        customDialogBinding.btnBackYes.setOnClickListener {
            this@ExerciseActivity.finish()
            customDialog.dismiss()
        }
        customDialogBinding.btnBackNo.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()
    }

    /** NOTE: HANDLES ALL USER'S BACK-PRESSED EVENTS(FROM DEVICE NAVIGATION, FROM CUSTOM TOOLBAR ETC...)! */
    override fun onBackPressed() {
        customDialogForBackButton()
    }

    override fun onDestroy() {
        super.onDestroy()

        // on activity destroy, stop the timers
        if (this.restTimer != null){
            this.restTimer?.cancel()
            this.restProgress = 0
        }
        if (this.exerciseTimer != null){
            this.exerciseTimer?.cancel()
            this.exerciseProgress = 0
        }

        // shutdown the text-to-speech
        if (this.textToSpeech != null){
            this.textToSpeech?.stop()
            this.textToSpeech?.shutdown()
        }

        // let the resources for mediaPlayer
        if (this.mediaPlayer != null){
            this.mediaPlayer?.release()
        }

        // reset the view inflated object
        this.binding = null
    }
}