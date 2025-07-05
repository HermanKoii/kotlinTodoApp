package com.todoapp.model

import com.example.todoapp.data.TodoItem

data class Todo(
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    // Conversion method to convert Todo to TodoItem
    fun toTodoItem(): TodoItem {
        return TodoItem(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }

    companion object {
        // Conversion method to create Todo from TodoItem
        fun fromTodoItem(todoItem: TodoItem): Todo {
            return Todo(
                id = todoItem.id,
                title = todoItem.title,
                description = todoItem.description,
                isCompleted = todoItem.isCompleted,
                createdAt = todoItem.createdAt,
                updatedAt = todoItem.updatedAt
            )
        }
    }
}