package com.todoapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.todoapp.R
import com.todoapp.model.Todo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class TodoListAdapterTest {

    private lateinit var adapter: TodoListAdapter

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        adapter = TodoListAdapter(
            onItemClick = {},
            onCompletionToggle = { _, _ -> }
        )
    }

    @Test
    fun testAdapterItemCount() {
        val todos = listOf(
            Todo(1, "Test Todo 1"),
            Todo(2, "Test Todo 2")
        )
        adapter.submitList(todos)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun testTodoCompletionToggle() {
        var toggledTodo: Todo? = null
        var toggledStatus: Boolean? = null

        adapter = TodoListAdapter(
            onItemClick = {},
            onCompletionToggle = { todo, isCompleted ->
                toggledTodo = todo
                toggledStatus = isCompleted
            }
        )

        val todo = Todo(1, "Test Todo", isCompleted = false)
        adapter.submitList(listOf(todo))

        val viewHolder = adapter.onCreateViewHolder(
            RecyclerView(RuntimeEnvironment.getApplication()),
            0
        )

        val checkBox = viewHolder.itemView.findViewById<View>(R.id.todo_completed_checkbox)
        
        // Simulate checkbox state change
        checkBox.isChecked = true
        checkBox.callOnClick()

        assertEquals(todo.id, toggledTodo?.id)
        assertEquals(true, toggledStatus)
    }

    @Test
    fun testTodoItemCreation() {
        val todo = Todo(
            id = 1,
            title = "Test Todo",
            description = "Test Description",
            isCompleted = false
        )

        assertEquals(1, todo.id)
        assertEquals("Test Todo", todo.title)
        assertEquals("Test Description", todo.description)
        assertFalse(todo.isCompleted)
    }
}