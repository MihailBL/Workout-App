package com.example.workoutapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.hardware.biometrics.BiometricManager.Strings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.RecyclerviewHistorySectionItemBinding

class HistoryAdapter(private val listOfCompletedExercises: ArrayList<String>,
                     private val btnDeleteListener: (date: String) -> Unit) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(binding: RecyclerviewHistorySectionItemBinding) : RecyclerView.ViewHolder(binding.root){
        val llItemView = binding.llHistorySectionItem
        val tvItemId = binding.tvItemId
        val tvCompletedExerciseDate = binding.tvCompletedExerciseDate
        val btnDeleteCompletedExercise = binding.btnDeleteCompletedExercises
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerviewHistorySectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dateString = this.listOfCompletedExercises[position].toString()
        holder.tvItemId.text = (position + 1).toString()
        holder.tvCompletedExerciseDate.text = dateString

        if (position % 2 == 0){
            holder.llItemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        else{
            holder.llItemView.setBackgroundColor(Color.parseColor("#EBEBEB"))
        }

        // Invoke the btn Delete in History Activity
        holder.btnDeleteCompletedExercise.setOnClickListener {
            this.btnDeleteListener.invoke(dateString)
        }
    }

    override fun getItemCount(): Int {
        return this.listOfCompletedExercises.size
    }
}