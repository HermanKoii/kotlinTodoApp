package com.todoapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.todoapp.data.Todo
import com.todoapp.data.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class TodoViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var mockRepository: TodoRepository

    private lateinit var viewModel: TodoViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = TodoViewModel(mockRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `insert todo successfully`() = testDispatcher.run {
        val todo = Todo(id = 0, title = "Test Todo", description = "Test Description", isCompleted = false)
        
        viewModel.insertTodo(todo)
        
        verify(mockRepository).insert(todo)
    }

    @Test
    fun `update todo successfully`() = testDispatcher.run {
        val todo = Todo(id = 1, title = "Updated Todo", description = "Updated Description", isCompleted = true)
        
        viewModel.updateTodo(todo)
        
        verify(mockRepository).update(todo)
    }

    @Test
    fun `get todo by id returns correct todo`() = testDispatcher.run {
        val expectedTodo = Todo(id = 1, title = "Test Todo", description = "Test Description", isCompleted = false)
        
        whenever(mockRepository.getTodoById(1)).thenReturn(expectedTodo)
        
        val result = viewModel.getTodoById(1)
        
        assertEquals(expectedTodo, result)
    }
}