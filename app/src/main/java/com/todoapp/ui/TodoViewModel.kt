package com.todoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.todoapp.data.Todo
import java.util.Date

class TodoViewModel : ViewModel() {
    private val _todoItems = MutableLiveData<List<Todo>>(
        listOf(
            Todo(1, "First Task", Date(), false),
            Todo(2, "Completed Task", Date(), true)
        )
    )
    val todoItems: LiveData<List<Todo>> = _todoItems

    fun addTodo(title: String, dueDate: Date? = null) {
        val currentList = _todoItems.value?.toMutableList() ?: mutableListOf()
        val newId = (currentList.maxOfOrNull { it.id } ?: 0) + 1
        val newTodo = Todo(newId, title, dueDate)
        currentList.add(newTodo)
        _todoItems.value = currentList
    }

    fun toggleTodoCompletion(id: Long) {
        val updatedList = _todoItems.value?.map { todo ->
            if (todo.id == id) todo.copy(isCompleted = !todo.isCompleted) else todo
        }
        _todoItems.value = updatedList
    }
}