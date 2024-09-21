package com.example.todolistappusingdagger

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val todoDao: ToDoDao
) {
    val allTasks: LiveData<List<ToDo>> = todoDao.getAllTasks()

    suspend fun insert(task: ToDo) {
        todoDao.insertTask(task)
    }

    suspend fun delete(task: ToDo) {
        todoDao.deleteTask(task)
    }
}
