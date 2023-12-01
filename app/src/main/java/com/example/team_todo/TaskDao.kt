package com.example.team_todo

import androidx.room.*

//Room DAOの詳細はこちら
//https://developer.android.com/training/data-storage/room/accessing-data?hl=ja

//各DAOは、インターフェースまたは抽象クラスとして定義できます。
//基本的なユースケースでは、通常はインターフェースを使用します。
//いずれの場合も、DAO には常に @Dao アノテーションを付ける必要があります。
//DAO にプロパティはありませんが、アプリのデータベース内のデータを操作する 1 つ以上のメソッドを定義します。


@Dao/**/
interface TaskDao {


    //  @Insert アノテーションを使用すると、
    //  データベース内の適切なテーブルにパラメータを挿入するメソッドを定義できます。
    @Insert
    fun insertTask(task: Task)

    //    @Queryアノテーションを使用すると、SQL ステートメントを記述して
    //    DAOメソッドとして公開できます。
    //    これらのクエリメソッドは、アプリのデータベースからデータをクエリする場合や、
    //    より複雑な挿入、更新、削除を行う必要がある場合に使用できます。
    @Query("SELECT * FROM Task")
    fun loadAllTasks()

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

}