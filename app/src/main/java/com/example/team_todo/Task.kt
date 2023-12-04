package com.example.team_todo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    //自動で生成するID
    @PrimaryKey(autoGenerate = true) val  id:Int = 0,
    var title:String,
    var description :String,
    var isFinish :Boolean,
//    UX的に不要
//    var week : Array<String>,
    var deadLine : Int
)
