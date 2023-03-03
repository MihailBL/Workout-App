package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.workoutapp.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    // ViewBinding object
    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set up binding
        this.binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(this.binding?.root)

        // Set up Support Action Bar
        setSupportActionBar(this.binding?.toolbarFinishActivity)
        if (supportActionBar != null){
            this.supportActionBar?.title = "WORKOUT APP"
            this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        this.binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        // Finish button
        this.binding?.btnFinish?.setOnClickListener {
            finish()
        }
        // Get the Instance From Dao
        val historySectionDao = (application as WorkoutApp).databaseInstance.value.historySectionDao()
        addDateToDatabase(historySectionDao)
    }

    // Adding exercises to the database
    private fun addDateToDatabase(historySectionDao: HistorySectionDao){
        // Get the date
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time

        // Convert the time with SimpleDateFormat
        val sdf = SimpleDateFormat("dd MM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)

        lifecycleScope.launch{
            historySectionDao.insert(HistorySectionEntity(date))
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        this.binding = null
    }
}