package com.example.android.architecture.blueprints.todoapp

import com.example.android.architecture.blueprints.todoapp.data.source.local.ToDoDatabase
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository

object ServiceLocator {

    private var database: ToDoDatabase? = null
    @Volatile
    var tasksRepository: TasksRepository? = null

}