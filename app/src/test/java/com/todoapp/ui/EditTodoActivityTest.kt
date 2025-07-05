package com.todoapp.ui

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.todoapp.R
import com.todoapp.data.Todo
import com.todoapp.viewmodel.TodoViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class EditTodoActivityTest {

    @Mock
    private lateinit var todoViewModel: TodoViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testEditTodoActivity_shouldInitializeCorrectly() {
        // Create an intent with a todo ID
        val intent = Intent(ApplicationProvider.getApplicationContext(), EditTodoActivity::class.java).apply {
            putExtra(EditTodoActivity.EXTRA_TODO_ID, 1L)
        }

        // Launch the activity
        val scenario = ActivityScenario.launch<EditTodoActivity>(intent)

        scenario.onActivity { activity ->
            // Check view initialization
            val titleEditText = activity.findViewById<EditText>(R.id.edit_todo_title)
            val descriptionEditText = activity.findViewById<EditText>(R.id.edit_todo_description)
            val completedSwitch = activity.findViewById<Switch>(R.id.edit_todo_completed_switch)
            val saveButton = activity.findViewById<Button>(R.id.save_todo_button)
            val cancelButton = activity.findViewById<Button>(R.id.cancel_todo_button)

            // Assert views are not null
            assertThat(titleEditText).isNotNull()
            assertThat(descriptionEditText).isNotNull()
            assertThat(completedSwitch).isNotNull()
            assertThat(saveButton).isNotNull()
            assertThat(cancelButton).isNotNull()
        }
    }

    @Test
    fun testSaveTodoItem_withValidInput() {
        // Create an intent with a todo ID
        val intent = Intent(ApplicationProvider.getApplicationContext(), EditTodoActivity::class.java).apply {
            putExtra(EditTodoActivity.EXTRA_TODO_ID, -1L)
        }

        // Launch the activity
        val scenario = ActivityScenario.launch<EditTodoActivity>(intent)

        scenario.onActivity { activity ->
            // Set up test data
            val titleEditText = activity.findViewById<EditText>(R.id.edit_todo_title)
            val descriptionEditText = activity.findViewById<EditText>(R.id.edit_todo_description)
            val completedSwitch = activity.findViewById<Switch>(R.id.edit_todo_completed_switch)
            val saveButton = activity.findViewById<Button>(R.id.save_todo_button)

            // Set input values
            titleEditText.setText("Test Todo")
            descriptionEditText.setText("Test Description")
            completedSwitch.isChecked = false

            // Simulate save button click
            saveButton.performClick()

            // Verify todo is saved (this would typically involve checking ViewModel interaction)
            runBlocking {
                val expectedTodo = Todo(
                    id = 0,
                    title = "Test Todo",
                    description = "Test Description",
                    isCompleted = false
                )
                // Note: In a real test, you'd mock the ViewModel and verify its methods
            }
        }
    }
}