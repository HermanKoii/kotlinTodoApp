package com.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.TodoItem

class TodoListAdapter(
    private val onItemClick: (TodoItem) -> Unit,
    private val onCompletionToggle: (TodoItem, Boolean) -> Unit
) : ListAdapter<TodoItem, TodoListAdapter.TodoViewHolder>(TodoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view, onItemClick, onCompletionToggle)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoViewHolder(
        itemView: View,
        private val onItemClick: (TodoItem) -> Unit,
        private val onCompletionToggle: (TodoItem, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.todo_title)
        private val completedCheckBox: CheckBox = itemView.findViewById(R.id.todo_completed_checkbox)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.todo_description)

        fun bind(todoItem: TodoItem) {
            titleTextView.text = todoItem.title
            completedCheckBox.isChecked = todoItem.isCompleted
            descriptionTextView.text = todoItem.description ?: ""

            itemView.setOnClickListener { onItemClick(todoItem) }

            completedCheckBox.setOnCheckedChangeListener { _, isChecked ->
                onCompletionToggle(todoItem, isChecked)
            }
        }
    }

    // DiffUtil for efficient list updates
    class TodoDiffCallback : DiffUtil.ItemCallback<TodoItem>() {
        override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem == newItem
        }
    }
}