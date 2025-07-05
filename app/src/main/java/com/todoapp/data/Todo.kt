package com.todoapp.data

import java.util.Date

data class Todo(
    val id: Long = 0,
    val title: String,
    val dueDate: Date? = null,
    val isCompleted: Boolean = false
)