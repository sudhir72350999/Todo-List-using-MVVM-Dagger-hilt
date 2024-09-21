package com.example.todolistappusingdagger

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ToDoViewModel by viewModels()
    private lateinit var adapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val taskInput: EditText = findViewById(R.id.task_input)
        val addTaskButton: Button = findViewById(R.id.add_task_button)

        adapter = ToDoAdapter { task -> viewModel.delete(task) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.allTasks.observe(this, { tasks ->
            tasks?.let { adapter.submitList(it) }
        })

        addTaskButton.setOnClickListener {
            val taskText = taskInput.text.toString()
            if (taskText.isNotEmpty()) {
                viewModel.insert(ToDo(task = taskText))
                taskInput.text.clear()
            }
        }
    }
}
