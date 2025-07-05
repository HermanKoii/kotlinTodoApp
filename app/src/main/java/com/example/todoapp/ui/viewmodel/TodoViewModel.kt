package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.TodoItem
import com.example.todoapp.data.dao.TodoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val todoDao: TodoDao) : ViewModel() {
    fun deleteTodo(todoItem: TodoItem) {
        CoroutineScope(Dispatchers.IO).launch {
            todoDao.deleteTodo(todoItem)
        }
    }
}