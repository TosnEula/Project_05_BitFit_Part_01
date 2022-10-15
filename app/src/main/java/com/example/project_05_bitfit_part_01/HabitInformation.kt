package com.example.project_05_bitfit_part_01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class HabitInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_information)

        val submitBtn: Button = findViewById(R.id.moveInfoBtn)
        val nameEdtView: EditText = findViewById(R.id.habitNameET)
        val valueEdtView: EditText = findViewById(R.id.habitValueET)

        var habitDetails: ArrayList<String> = ArrayList()

        submitBtn.setOnClickListener(View.OnClickListener {

            var namePassed = nameEdtView.text.toString()
            var valuePassed = valueEdtView.text.toString()

            lifecycleScope.launch(IO) {
                (application as HabitApplication).db.articleDao().insert(
                    HabitEntity(
                        habitName = namePassed,
                        habitValue = valuePassed
                    )
                )
            }



            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("HABIT_EXTRA",habitDetails)
            this.startActivity(intent)
        })


    }


}