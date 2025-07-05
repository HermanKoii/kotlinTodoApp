package com.todoapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.todoapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EditTodoActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(EditTodoActivity::class.java)

    @Test
    fun testTodoCreation() {
        // Enter todo title
        onView(withId(R.id.edit_todo_title))
            .perform(typeText("Test Todo"), closeSoftKeyboard())

        // Enter todo description
        onView(withId(R.id.edit_todo_description))
            .perform(typeText("This is a test description"), closeSoftKeyboard())

        // Click save button
        onView(withId(R.id.save_todo_button))
            .perform(click())

        // Verify behavior (could be checking for toast or navigation)
    }

    @Test
    fun testEmptyTitleValidation() {
        // Leave title empty
        onView(withId(R.id.edit_todo_title))
            .perform(clearText(), closeSoftKeyboard())

        // Click save button
        onView(withId(R.id.save_todo_button))
            .perform(click())

        // Verify error state (depends on how you implement validation)
        onView(withId(R.id.edit_todo_title))
            .check(matches(hasErrorText("Title cannot be empty")))
    }

    @Test
    fun testCompletedSwitch() {
        // Toggle completed switch
        onView(withId(R.id.edit_todo_completed_switch))
            .perform(click())

        // Verify switch state changed
        onView(withId(R.id.edit_todo_completed_switch))
            .check(matches(isChecked()))
    }
}