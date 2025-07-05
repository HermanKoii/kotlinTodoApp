package com.example.todoapp.ui.viewmodel

import com.example.todoapp.data.model.Todo

class TodoViewModel {
    private val todos = mutableListOf<Todo>()

    fun deleteTodo(todo: Todo) {
        todos.remove(todo)
    }

    fun getTodos(): List<Todo> = todos.toList()
}