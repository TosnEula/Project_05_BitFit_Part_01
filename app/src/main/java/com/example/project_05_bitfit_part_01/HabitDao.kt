package com.example.project_05_bitfit_part_01

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    fun getAll(): Flow<List<HabitEntity>>

    @Insert
    fun insertAll(habits: List<HabitEntity>)

    @Insert
    fun insert(habits: HabitEntity)

    @Query("DELETE FROM habit_table")
    fun deleteAll()
}