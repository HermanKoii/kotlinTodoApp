package com.todoapp.model

import java.util.Date

data class TodoItem(
    val id: Long,
    val title: String,
    val dueDate: Date? = null,
    val isCompleted: Boolean = false
)