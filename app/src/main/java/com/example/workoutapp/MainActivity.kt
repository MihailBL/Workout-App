package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // FrameLayout as start button -- using viewBinding
        this.binding?.flStart?.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        // FrameLayout as exit button -- using findViewById()
        val flExitButton: FrameLayout = findViewById(R.id.fl_exit)
        flExitButton.setOnClickListener {
            finish()
        }

        // FrameLayout as BMI button
        this.binding?.flBMISection?.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        // FrameLayout as History button
        this.binding?.flHistorySection?.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    /** NOTE: RESET BINDING OBJECT TO NULL WHEN CLOSING THIS ACTIVITY TO AVOID MEMORY LEAKS!!! */
    override fun onDestroy() {
        super.onDestroy()

        this.binding = null
    }
}