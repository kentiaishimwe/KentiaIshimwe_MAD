package com.example.todo.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {
    var taskList = mutableStateListOf<ToDo>()

    fun add (newTask : ToDo) {
        taskList.add(newTask)
    }

    fun delete (task : ToDo){
        taskList.remove(task)
    }


}