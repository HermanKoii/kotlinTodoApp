package com.todoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.todoapp.R
import com.todoapp.data.Todo
import com.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        // Setup RecyclerView
        setupRecyclerView()

        // Observe todo items and update adapter
        todoViewModel.todoItems.observe(this) { todos ->
            todoAdapter.submitList(todos)
        }

        // Setup Add Todo button
        binding.addTodoButton.setOnClickListener {
            val todoText = binding.todoEditText.text.toString().trim()
            if (todoText.isNotEmpty()) {
                val newTodo = Todo(
                    id = System.currentTimeMillis(), // Unique ID
                    title = todoText,
                    isCompleted = false
                )
                todoViewModel.addTodo(newTodo)
                binding.todoEditText.text.clear()
            }
        }
    }

    private fun setupRecyclerView() {
        todoAdapter = TodoAdapter(
            onItemClick = { todo -> 
                // Edit todo - open edit dialog or navigate to edit screen
                todoViewModel.updateTodo(todo.copy(title = todo.title + " (edited)"))
            },
            onDeleteClick = { todo ->
                todoViewModel.deleteTodo(todo)
            },
            onCompleteToggle = { todo ->
                todoViewModel.toggleTodoCompletion(todo)
            }
        )

        binding.todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = todoAdapter
        }
    }
}