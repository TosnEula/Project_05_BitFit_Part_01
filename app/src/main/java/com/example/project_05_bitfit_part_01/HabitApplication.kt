package com.example.project_05_bitfit_part_01

import android.app.Application

class HabitApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }

}
