package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.workoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    // Create binding
    private var binding: ActivityHistoryBinding? = null

    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set up binding
        this.binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(this.binding?.root)

        // Set up support action bar
        setSupportActionBar(this.binding?.toolbarHistoryActivity)
        if (this.supportActionBar != null){
            this.supportActionBar?.title = "HISTORY"
            this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        this.binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        // Get Instance from Dao via Database
        val historySectionDao = (application as WorkoutApp).databaseInstance.value.historySectionDao()
        getAllDatesOfCompletedExercises(historySectionDao)
    }

    // Get All the dates of completed Exercises
    private fun getAllDatesOfCompletedExercises(historySectionDao: HistorySectionDao){
        lifecycleScope.launch {
           val completedExercisesList = historySectionDao.getAllDatesForCompletedExercises()
            if (completedExercisesList.isNotEmpty()){
                binding?.tvNoCompletedExerciseDateTitle?.visibility = View.GONE
                binding?.tvCompletedExerciseDateTitle?.visibility = View.VISIBLE
                binding?.rvHistorySection?.visibility = View.VISIBLE

                // Create adapter object
                val arrayListCompletedExercises = ArrayList<String>()
                for (element in completedExercisesList) {
                    arrayListCompletedExercises.add(element.date)
                }
                 adapter = HistoryAdapter(arrayListCompletedExercises) { date ->
                    deleteCompletedExercise(historySectionDao, date)
                }

                // Set up the RecyclerView
                val rvHistorySection = binding?.rvHistorySection
                rvHistorySection?.layoutManager = LinearLayoutManager(this@HistoryActivity, LinearLayoutManager.VERTICAL, false)
                rvHistorySection?.adapter = adapter
            }
            else{
                binding?.tvNoCompletedExerciseDateTitle?.visibility = View.VISIBLE
                binding?.tvCompletedExerciseDateTitle?.visibility = View.GONE
                binding?.rvHistorySection?.visibility = View.GONE
            }
        }
    }

    /** Method for delete Listener */
    private fun deleteCompletedExercise(historySectionDao: HistorySectionDao, date: String){
        lifecycleScope.launch {
            historySectionDao.delete(HistorySectionEntity(date))
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        this.binding = null
    }
}