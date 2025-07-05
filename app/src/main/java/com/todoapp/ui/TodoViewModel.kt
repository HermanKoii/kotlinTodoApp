package com.todoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.todoapp.model.TodoItem

class TodoViewModel : ViewModel() {
    // Mutable list of todo items
    private val _todoItems = MutableLiveData<List<TodoItem>>(emptyList())
    val todoItems: LiveData<List<TodoItem>> = _todoItems

    // Add a new todo item
    fun addTodo(todoItem: TodoItem) {
        val currentList = _todoItems.value?.toMutableList() ?: mutableListOf()
        currentList.add(todoItem)
        _todoItems.value = currentList
    }

    // Update an existing todo item
    fun updateTodo(updatedTodoItem: TodoItem) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        val index = currentList.indexOfFirst { it.id == updatedTodoItem.id }
        if (index != -1) {
            currentList[index] = updatedTodoItem
            _todoItems.value = currentList
        }
    }

    // Delete a todo item
    fun deleteTodo(todoItem: TodoItem) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        currentList.removeAll { it.id == todoItem.id }
        _todoItems.value = currentList
    }

    // Toggle todo completion status
    fun toggleTodoCompletion(todoItem: TodoItem) {
        val currentList = _todoItems.value?.toMutableList() ?: return
        val index = currentList.indexOfFirst { it.id == todoItem.id }
        if (index != -1) {
            val updatedTodoItem = currentList[index].copy(isCompleted = !currentList[index].isCompleted)
            currentList[index] = updatedTodoItem
            _todoItems.value = currentList
        }
    }
}