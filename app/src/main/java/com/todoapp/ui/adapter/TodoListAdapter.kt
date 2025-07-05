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
import com.todoapp.data.Todo
import java.text.SimpleDateFormat
import java.util.Locale

class TodoListAdapter(
    private val onItemClick: (Todo) -> Unit,
    private val onCompletionToggle: (Todo) -> Unit
) : ListAdapter<Todo, TodoListAdapter.TodoItemViewHolder>(TodoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item_layout, parent, false)
        return TodoItemViewHolder(view, onItemClick, onCompletionToggle)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoItemViewHolder(
        itemView: View,
        private val onItemClick: (Todo) -> Unit,
        private val onCompletionToggle: (Todo) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.todo_title)
        private val dueDateTextView: TextView = itemView.findViewById(R.id.todo_due_date)
        private val completionCheckBox: CheckBox = itemView.findViewById(R.id.todo_completion_checkbox)

        fun bind(todoItem: Todo) {
            titleTextView.text = todoItem.title
            completionCheckBox.isChecked = todoItem.isCompleted

            // Handle due date
            if (todoItem.dueDate != null) {
                val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                dueDateTextView.text = dateFormat.format(todoItem.dueDate)
                dueDateTextView.visibility = View.VISIBLE
            } else {
                dueDateTextView.visibility = View.GONE
            }

            // Set up click listeners
            itemView.setOnClickListener { onItemClick(todoItem) }
            completionCheckBox.setOnClickListener { onCompletionToggle(todoItem) }
        }
    }

    private class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }
}