package com.example.todolistappusingdagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(
    private val onDelete: (ToDo) -> Unit
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private var tasks = listOf<ToDo>()

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskText: TextView = itemView.findViewById(R.id.task_text)
        private val deleteButton: Button = itemView.findViewById(R.id.delete_button)

        fun bind(task: ToDo) {
            taskText.text = task.task
            deleteButton.setOnClickListener { onDelete(task) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun submitList(newTasks: List<ToDo>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}
