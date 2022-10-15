package com.example.project_05_bitfit_part_01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent


class HabitAdapter(private val context: Context, private val habits: List<DisplayHabit>) :
    RecyclerView.Adapter<HabitAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        //instantiate variables for the adapter from habit_item.xml
         val nameTextView = itemView.findViewById<TextView>(R.id.habitNameTV)
         val valueTextView=  itemView.findViewById<TextView>(R.id.habitValueTV)

        init {
            itemView.setOnClickListener(this)
        }

        //A helper method to help set up the onBindViewHolder method
        fun bind(habit: DisplayHabit) {
            nameTextView.text = habit.habitName
            valueTextView.text = habit.habitValue
        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Get the individual article and bind to holder
        val habit = habits[position]
        holder.bind(habit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val view = LayoutInflater.from(context).inflate(R.layout.habit_item, parent, false)
        // Return a new holder instance
        return ViewHolder(view)
    }




    override fun getItemCount(): Int {
        return habits.size
    }

}