package com.example.team_todo

import androidx.room.Database
import androidx.room.RoomDatabase
//import com.example.team_todo.Task
//import com.example.team_todo.TaskDao

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun taskDao() : TaskDao


}