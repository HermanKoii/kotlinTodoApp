package com.todoapp.viewmodel

import com.todoapp.data.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {
    private lateinit var todoViewModel: TodoViewModel

    @Before
    fun setup() {
        todoViewModel = TodoViewModel()
    }

    @Test
    fun testInsertAndGetTodo() = runBlocking {
        val todo = Todo(
            id = 0,
            title = "Test Todo",
            description = "Test Description",
            isCompleted = false
        )

        val insertedId = todoViewModel.insertTodo(todo)
        assertNotNull(insertedId)

        val retrievedTodo = todoViewModel.getTodoById(insertedId)
        assertNotNull(retrievedTodo)
        assertEquals(todo.title, retrievedTodo?.title)
        assertEquals(todo.description, retrievedTodo?.description)
        assertEquals(todo.isCompleted, retrievedTodo?.isCompleted)
    }

    @Test
    fun testUpdateTodo() = runBlocking {
        val todo = Todo(
            id = 0,
            title = "Initial Todo",
            description = "Initial Description",
            isCompleted = false
        )

        val insertedId = todoViewModel.insertTodo(todo)

        val updatedTodo = todo.copy(
            title = "Updated Todo",
            isCompleted = true
        )

        todoViewModel.updateTodo(updatedTodo)

        val retrievedTodo = todoViewModel.getTodoById(insertedId)
        assertNotNull(retrievedTodo)
        assertEquals("Updated Todo", retrievedTodo?.title)
        assertEquals(true, retrievedTodo?.isCompleted)
    }
}