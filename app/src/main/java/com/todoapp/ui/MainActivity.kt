package com.todoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.todoapp.R
import com.todoapp.databinding.ActivityMainBinding
import com.todoapp.model.TodoItem
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var todoListAdapter: TodoListAdapter

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
            todoListAdapter.submitList(todos)
        }

        // Setup Add Todo button
        binding.addTodoButton.setOnClickListener {
            val todoText = binding.todoEditText.text.toString().trim()
            if (todoText.isNotEmpty()) {
                val newTodo = TodoItem(
                    id = System.currentTimeMillis(), // Unique ID
                    title = todoText,
                    dueDate = Date(), // Current date
                    isCompleted = false
                )
                todoViewModel.addTodo(newTodo)
                binding.todoEditText.text.clear()
            }
        }
    }

    private fun setupRecyclerView() {
        todoListAdapter = TodoListAdapter(
            onItemClick = { todo -> 
                // Edit todo - for now, just print or log
                println("Clicked todo: $todo")
            },
            onCompletionToggle = { todo ->
                todoViewModel.toggleTodoCompletion(todo)
            }
        )

        binding.todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = todoListAdapter
        }
    }
}