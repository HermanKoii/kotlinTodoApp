// DEPRECATED: Replaced by TodoItem in com.example.todoapp.data.model
// This file is kept for historical reference and will be removed in future refactoring
package com.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * @deprecated Use TodoItem from com.example.todoapp.data.model instead
 */
@Deprecated("Use TodoItem from com.example.todoapp.data.model package")
@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false,

    @ColumnInfo(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "due_date")
    val dueDate: LocalDateTime? = null
) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(title.length <= 100) { "Title cannot exceed 100 characters" }
        description?.let {
            require(it.length <= 500) { "Description cannot exceed 500 characters\" }\n        }\n    }\n}