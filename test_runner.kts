#!/usr/bin/env kotlin

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import java.time.LocalDateTime
import com.todoapp.model.Todo

fun main() {
    // Test create todo with valid data
    val todo = Todo.create(title = "Test Todo")
    assert(todo.id.isNotEmpty()) { "ID should not be empty" }
    assert(todo.title == "Test Todo") { "Title should match" }
    assert(!todo.isCompleted) { "Initial completion status should be false" }
    assertNotNull(todo.createdAt)

    // Test toggle completion
    val toggledTodo = todo.toggleCompletion()
    assert(toggledTodo.isCompleted) { "Toggled todo should be completed" }
    assert(todo !== toggledTodo) { "Toggle should create a new instance" }

    // Test creating todo with all properties
    val description = "Test description"
    val dueDate = LocalDateTime.now().plusDays(1)
    val fullTodo = Todo(
        title = "Complete Project", 
        description = description,
        priority = Todo.Priority.HIGH,
        dueDate = dueDate
    )
    assert(fullTodo.title == "Complete Project") { "Title should match" }
    assert(fullTodo.description == description) { "Description should match" }
    assert(fullTodo.priority == Todo.Priority.HIGH) { "Priority should match" }
    assert(fullTodo.dueDate == dueDate) { "Due date should match" }

    // Test title validation
    try {
        Todo.create(title = "")
        error("Empty title should throw exception")
    } catch (e: IllegalArgumentException) {
        // Expected
    }

    try {
        Todo.create(title = "a".repeat(101))
        error("Long title should throw exception")
    } catch (e: IllegalArgumentException) {
        // Expected
    }

    // Test description validation
    try {
        Todo.create(
            title = "Valid Title", 
            description = "a".repeat(501)
        )
        error("Long description should throw exception")
    } catch (e: IllegalArgumentException) {
        // Expected
    }

    // Test due date validation
    try {
        Todo(
            title = "Test Todo", 
            dueDate = LocalDateTime.now().minusDays(1)
        )
        error("Past due date should throw exception")
    } catch (e: IllegalArgumentException) {
        // Expected
    }

    println("All tests passed successfully!")
}

main()