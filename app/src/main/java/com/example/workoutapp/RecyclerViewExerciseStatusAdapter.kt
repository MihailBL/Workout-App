package com.example.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.RecyclerviewItemExerciseStatusBinding

class RecyclerViewExerciseStatusAdapter(val exerciseList: ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<RecyclerViewExerciseStatusAdapter.ViewHolder>(){

    /** CREATE OUR OWN VIEW HOLDER TO BIND THE ITEM PROPERTIES WITH THE DATA MODEL!!! */
    inner class ViewHolder (binding: RecyclerviewItemExerciseStatusBinding) : RecyclerView.ViewHolder(binding.root){
        val tvItem = binding.tvRecyclerViewItem
    }

    /** When Recyclerview is created */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerviewItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    /** What should happen on every single item */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = this.exerciseList[position]
        holder.tvItem.text = exercise.getId().toString()
        
        when{
            exercise.getIsSelected() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.recyclerview_item_circular_color_background_selected)
            }
            exercise.getIsCompleted() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.recyclerview_item_circular_color_background_completed)
                holder.tvItem.setTextColor(Color.parseColor("#006400"))
            }
            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.recyclerview_item_circular_color_background)
                holder.tvItem.setTextColor(Color.parseColor("#3C4735"))
            }
        }
    }

    override fun getItemCount(): Int {
        return this.exerciseList.size
    }
}