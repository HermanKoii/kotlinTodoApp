// Deprecated: Replaced by TodoItem in com.example.todoapp.data package
// This file is kept for reference and will be removed in future refactoring
package com.todoapp.model

// Keeping this as a compatibility layer
@Deprecated("Use TodoItem from com.example.todoapp.data instead")
data class Todo(
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false
)