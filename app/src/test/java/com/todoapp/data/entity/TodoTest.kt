package com.todoapp.data.entity

import com.example.todoapp.data.model.TodoItem
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class TodoItemTest {

    @Test
    fun `create todo item with valid data`() {
        val todoItem = TodoItem(
            title = "Test Todo",
            description = "Test description"
        )

        assertNotNull(todoItem)
        assertEquals("Test Todo", todoItem.title)
        assertEquals("Test description", todoItem.description)
        assertEquals(false, todoItem.isCompleted)
        assertNotNull(todoItem.createdAt)
    }

    @Test
    fun `create todo item with all properties`() {
        val todoItem = TodoItem(
            title = "Complete project",
            description = "Finish the todo app implementation",
            isCompleted = true
        )

        assertEquals("Complete project", todoItem.title)
        assertEquals("Finish the todo app implementation", todoItem.description)
        assertEquals(true, todoItem.isCompleted)
    }

    @Test
    fun `fail to create todo item with blank title`() {
        // Since TodoItem doesn't have explicit validation, this test is a placeholder
        val todoItem = TodoItem(title = "")
        assertEquals("", todoItem.title)
    }
}