package com.todoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.todoapp.data.Todo
import com.todoapp.databinding.ItemTodoBinding

class TodoAdapter(
    private val onItemClick: (Todo) -> Unit,
    private val onDeleteClick: (Todo) -> Unit,
    private val onCompleteToggle: (Todo) -> Unit
) : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding, onItemClick, onDeleteClick, onCompleteToggle)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoViewHolder(
        private val binding: ItemTodoBinding,
        private val onItemClick: (Todo) -> Unit,
        private val onDeleteClick: (Todo) -> Unit,
        private val onCompleteToggle: (Todo) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.todoTitleTextView.text = todo.title
            binding.todoCheckBox.isChecked = todo.isCompleted

            // Set click listeners
            binding.root.setOnClickListener { onItemClick(todo) }
            binding.deleteButton.setOnClickListener { onDeleteClick(todo) }
            binding.todoCheckBox.setOnCheckedChangeListener { _, _ -> onCompleteToggle(todo) }
        }
    }

    class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }
}