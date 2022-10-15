package com.example.project_05_bitfit_part_01

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "habitName") val habitName: String?,
    @ColumnInfo(name = "habitValue") val habitValue: String?
    )