package com.todoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.todoapp.data.Todo

class TodoViewModel : ViewModel() {
    // Mutable list of todo items
    private val _todoItems = MutableLiveData<List<Todo>>(emptyList())
    val todoItems: LiveData<List<Todo>> = _todoItems

    // Add a new todo item
    fun addTodo(todo: Todo) {
        val currentList = _todoItems.value?.toMutableList() ?: mutableListOf()
        currentList.add(todo)
        _todoItems.value = currentList
    }

    // Update an existing todo item
    fun updateTodo(updatedTodo: Todo) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        val index = currentList.indexOfFirst { it.id == updatedTodo.id }
        if (index != -1) {
            currentList[index] = updatedTodo
            _todoItems.value = currentList
        }
    }

    // Delete a todo item
    fun deleteTodo(todo: Todo) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        currentList.removeAll { it.id == todo.id }
        _todoItems.value = currentList
    }

    // Toggle todo completion status
    fun toggleTodoCompletion(todo: Todo) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        val index = currentList.indexOfFirst { it.id == todo.id }
        if (index != -1) {
            val updatedTodo = currentList[index].copy(isCompleted = !currentList[index].isCompleted)
            currentList[index] = updatedTodo
            _todoItems.value = currentList
        }
    }
}