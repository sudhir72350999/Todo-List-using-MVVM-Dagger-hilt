package com.example.todolistappusingdagger

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: ToDo)

    @Delete
    suspend fun deleteTask(task: ToDo)

//    @Update
//    suspend fun updateTask(task: ToDo)

}
