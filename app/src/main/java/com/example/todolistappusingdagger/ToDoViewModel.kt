package com.example.todolistappusingdagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val allTasks: LiveData<List<ToDo>> = repository.allTasks

    fun insert(task: ToDo) {
        viewModelScope.launch {
            repository.insert(task)
        }
    }

    fun delete(task: ToDo) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }
}
