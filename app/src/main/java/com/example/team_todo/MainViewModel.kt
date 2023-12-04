package com.example.team_todo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

//
@HiltViewModel
class MainViewModel @Inject constructor(private val taskDao: TaskDao): ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")

    //ViewModel(このクラス)で変数を定義したら画面回転の影響を受けない
    var isShowDialog by mutableStateOf(false)

    var isFinish by mutableStateOf(false)
    var deadLine by mutableStateOf(0)

    //distinctUntilChanged = DBに変更があったがtaskの中身に変更がなければ更新しない
    val tasks = taskDao.loadAllTasks().distinctUntilChanged()


    private var editingTask: Task? = null
    val isEditing: Boolean
        get() = editingTask != null

    fun setEditingTask(task: Task){
        editingTask = task
        title = task.title
        description = task.description
        deadLine = task.deadLine
    }



    fun createTask(){
        viewModelScope.launch {
            val newTask = Task(
                title = title,
                description = description,
                isFinish =  isFinish,
                deadLine = deadLine,
                )
            taskDao.insertTask(newTask)
//            Log.d(
//                MainViewModel::class.simpleName,
//                "success create task"
//            )
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }


    fun updateTask(){
        editingTask?.let{ task ->
            viewModelScope.launch {
                task.title = title
                task.description = description
                task.isFinish = isFinish
                task.deadLine = deadLine
                taskDao.updateTask(task)
            }
        }
    }


    fun resetProperties(){
        editingTask = null
        title = ""
        description = ""
        isFinish = false
        deadLine = 0
    }
}