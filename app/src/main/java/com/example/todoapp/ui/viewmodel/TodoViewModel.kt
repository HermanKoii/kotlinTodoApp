package com.example.todoapp.ui.viewmodel

import com.example.todoapp.data.entity.TodoItem

class TodoViewModel {
    fun deleteTodo(todoItem: TodoItem) {
        // Basic implementation for testing
        // In a real app, this would interact with a repository
        println("Deleting todo item: ${todoItem.title}")
    }
}