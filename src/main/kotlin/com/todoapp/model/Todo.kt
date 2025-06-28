package com.todoapp.model

import java.time.LocalDateTime
import java.util.UUID

/**
 * Represents a Todo item with comprehensive properties and validation.
 *
 * @property id Unique identifier for the Todo item
 * @property title Title of the Todo item (must not be blank and <= 100 chars)
 * @property description Optional description of the Todo item (<=500 chars)
 * @property isCompleted Current completion status of the Todo item
 * @property priority Priority level of the Todo item
 * @property createdAt Timestamp of Todo item creation
 * @property dueDate Optional due date for the Todo item
 */
data class Todo(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.MEDIUM,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val dueDate: LocalDateTime? = null
) {
    /**
     * Enum representing Todo item priority levels
     */
    enum class Priority {
        LOW, MEDIUM, HIGH
    }

    init {
        // Validation for title
        require(title.isNotBlank()) { "Todo title cannot be blank" }
        require(title.length <= 100) { "Title must be 100 characters or less" }
        
        // Description validation
        description?.let {
            require(it.length <= 500) { "Description must be 500 characters or less" }
        }
        
        // Optional: Additional validation for due date
        dueDate?.let { 
            require(it.isAfter(createdAt)) { "Due date must be after creation date" }
        }
    }

    /**
     * Creates a copy of the Todo item with updated completion status
     */
    fun toggleCompletion(): Todo = copy(isCompleted = !isCompleted)

    companion object {
        /**
         * Factory method for creating Todo items with optional parameters
         */
        fun create(
            title: String,
            description: String? = null,
            isCompleted: Boolean = false,
            priority: Priority = Priority.MEDIUM,
            dueDate: LocalDateTime? = null
        ): Todo = Todo(
            title = title,
            description = description,
            isCompleted = isCompleted,
            priority = priority,
            dueDate = dueDate
        )
    }
}