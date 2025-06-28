package com.todoapp.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TodoTest {

    @Test
    fun `create todo with valid data`() {
        val todo = Todo.create(title = "Test Todo")
        
        assertNotNull(todo.id)
        assertEquals("Test Todo", todo.title)
        assertFalse(todo.isCompleted)
        assertEquals(Todo.Priority.MEDIUM, todo.priority)
        assertNotNull(todo.createdAt)
    }

    @Test
    fun `toggle completion changes status`() {
        val todo = Todo.create(title = "Test Todo")
        val toggledTodo = todo.toggleCompletion()
        
        assertTrue(toggledTodo.isCompleted)
        assertNotSame(todo, toggledTodo)
    }

    @Test
    fun `create todo with all optional properties`() {
        val description = "Test description"
        val dueDate = LocalDateTime.now().plusDays(1)
        
        val todo = Todo.create(
            title = "Complete Project", 
            description = description,
            priority = Todo.Priority.HIGH,
            dueDate = dueDate
        )
        
        assertEquals("Complete Project", todo.title)
        assertEquals(description, todo.description)
        assertEquals(Todo.Priority.HIGH, todo.priority)
        assertEquals(dueDate, todo.dueDate)
    }

    @Test
    fun `blank title throws exception`() {
        assertThrows<IllegalArgumentException> {
            Todo.create(title = "")
        }
    }

    @Test
    fun `throw exception for title longer than 100 characters`() {
        val longTitle = "a".repeat(101)
        assertThrows<IllegalArgumentException> {
            Todo.create(title = longTitle)
        }
    }

    @Test
    fun `throw exception for description longer than 500 characters`() {
        val longDescription = "a".repeat(501)
        assertThrows<IllegalArgumentException> {
            Todo.create(
                title = "Valid Title", 
                description = longDescription
            )
        }
    }

    @Test
    fun `allow null description`() {
        val todo = Todo.create(title = "Task with no description")
        
        assertNotNull(todo)
        assertEquals(null, todo.description)
    }

    @Test
    fun `invalid due date throws exception`() {
        val pastDate = LocalDateTime.now().minusDays(1)
        
        assertThrows<IllegalArgumentException> {
            Todo.create(
                title = "Test Todo", 
                dueDate = pastDate
            )
        }
    }
}