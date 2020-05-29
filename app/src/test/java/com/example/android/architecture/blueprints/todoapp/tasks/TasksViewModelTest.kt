package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Observer

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setNewTaskEvent() {

        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        tasksViewModel.addNewTask()

        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled(), (not(nullValue())))

    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))

    }
}