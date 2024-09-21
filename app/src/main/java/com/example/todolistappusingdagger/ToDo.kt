package com.example.todolistappusingdagger

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_table")
data class ToDo(
@PrimaryKey(autoGenerate = true)
val id: Int = 0,
val task: String,
val isCompleted: Boolean = false
)


