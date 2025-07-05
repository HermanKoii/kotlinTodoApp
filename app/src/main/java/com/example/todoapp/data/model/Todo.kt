package com.example.todoapp.data.model

data class Todo(
    val id: Long,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)