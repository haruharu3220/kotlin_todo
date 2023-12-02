package com.example.team_todo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//
@HiltViewModel
class MainViewModel @Inject constructor(private val taskDao: TaskDao): ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")

    //ここで変数を定義したら画面回転の影響を受けない
    var isShowDialog by mutableStateOf(false)
    fun createTask(){
        viewModelScope.launch {
            val newTask = Task(title = title, description = description)
            taskDao.insertTask(newTask)
            Log.d(
                MainViewModel::class.simpleName,
                "success create task"
            )
        }

    }
}