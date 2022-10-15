package com.example.project_05_bitfit_part_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_05_bitfit_part_01.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val habits = mutableListOf<DisplayHabit>()
    private lateinit var habitsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    val habitAdapter = HabitAdapter(this, habits)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        habitsRecyclerView = findViewById(R.id.habitListRV)
        //Set up ArticleAdapter with articles

        habitsRecyclerView.adapter = habitAdapter

        habitsRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            habitsRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        lifecycleScope.launch {
            (application as HabitApplication).db.articleDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayHabit(
                        entity.habitName,
                        entity.habitValue
                    )
                }.also { mappedList ->
                    habits.clear()
                    habits.addAll(mappedList)
                    habitAdapter.notifyDataSetChanged()
                }
            }
        }

        val addButton: Button = findViewById<Button>(R.id.addBtn)

        //Moves to second screen for adding a new item
        addButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HabitInformation::class.java)
            this.startActivity(intent)
        })


    }


}