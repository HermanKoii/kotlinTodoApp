package com.todoapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.todoapp.R
import com.todoapp.model.TodoItem
import java.text.SimpleDateFormat
import java.util.Locale

class TodoListAdapter(
    private val onItemClick: (TodoItem) -> Unit,
    private val onCompletionToggle: (TodoItem) -> Unit
) : ListAdapter<TodoItem, TodoListAdapter.TodoItemViewHolder>(TodoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)
        return TodoItemViewHolder(view, onItemClick, onCompletionToggle)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoItemViewHolder(
        itemView: View,
        private val onItemClick: (TodoItem) -> Unit,
        private val onCompletionToggle: (TodoItem) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.todo_title)
        private val dueDateTextView: TextView = itemView.findViewById(R.id.todo_due_date)
        private val completionCheckBox: CheckBox = itemView.findViewById(R.id.todo_completion_checkbox)

        fun bind(todoItem: TodoItem) {
            titleTextView.text = todoItem.title
            completionCheckBox.isChecked = todoItem.isCompleted

            // Handle due date
            if (todoItem.dueDate != null) {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                dueDateTextView.text = dateFormat.format(todoItem.dueDate)
                dueDateTextView.visibility = View.VISIBLE
            } else {
                dueDateTextView.visibility = View.GONE
            }

            // Set click listeners
            itemView.setOnClickListener { onItemClick(todoItem) }
            completionCheckBox.setOnCheckedChangeListener { _, _ -> onCompletionToggle(todoItem) }
        }
    }

    class TodoItemDiffCallback : DiffUtil.ItemCallback<TodoItem>() {
        override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
            return oldItem == newItem
        }
    }
}