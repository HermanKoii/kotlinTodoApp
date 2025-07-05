package com.example.todoapp.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.TodoItem
import com.example.todoapp.databinding.ItemTodoBinding
import com.example.todoapp.ui.viewmodel.TodoViewModel

/**
 * RecyclerView adapter for displaying and managing Todo items
 * 
 * @property context Android context for showing dialogs
 * @property viewModel ViewModel for handling Todo item operations
 * @property todoList List of Todo items to display
 */
class TodoListAdapter(
    private val context: Context,
    private val viewModel: TodoViewModel,
    private var todoList: List<TodoItem>
) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    /**
     * Shows a confirmation dialog before deleting a Todo item
     * 
     * @param todoItem The Todo item to be deleted
     */
    private fun showDeleteConfirmationDialog(todoItem: TodoItem) {
        AlertDialog.Builder(context)
            .setTitle(R.string.delete_todo_title)
            .setMessage(R.string.delete_todo_message)
            .setPositiveButton(R.string.delete) { dialog, _ ->\n                // Confirm deletion
                viewModel.deleteTodo(todoItem)
                dialog.dismiss()\n            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->\n                // Cancel deletion
                dialog.dismiss()\n            }
            .create()\n            .show()\n    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {\n        val binding = ItemTodoBinding.inflate(\n            LayoutInflater.from(parent.context), \n            parent, \n            false\n        )\n        return TodoViewHolder(binding)\n    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {\n        val todo = todoList[position]\n        holder.bind(todo)\n    }

    override fun getItemCount(): Int = todoList.size

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : \n        RecyclerView.ViewHolder(binding.root) {\n        \n        fun bind(todoItem: TodoItem) {\n            binding.apply {\n                // Set todo details\n                todoTitle.text = todoItem.title\n                todoDescription.text = todoItem.description\n\n                // Delete button click listener with confirmation dialog\n                deleteButton.setOnClickListener {\n                    showDeleteConfirmationDialog(todoItem)\n                }\n            }\n        }\n    }

    /**
     * Update the list of Todo items and notify the adapter
     * 
     * @param newList New list of Todo items
     */
    fun updateList(newList: List<TodoItem>) {\n        todoList = newList\n        notifyDataSetChanged()\n    }\n}