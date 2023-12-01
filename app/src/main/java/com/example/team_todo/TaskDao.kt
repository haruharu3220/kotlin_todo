package com.example.team_todo

import androidx.room.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

//Room DAOの詳細はこちら
//https://developer.android.com/training/data-storage/room/accessing-data?hl=ja

//各DAOは、インターフェースまたは抽象クラスとして定義できます。
//基本的なユースケースでは、通常はインターフェースを使用します。
//いずれの場合も、DAO には常に @Dao アノテーションを付ける必要があります。
//DAO にプロパティはありませんが、アプリのデータベース内のデータを操作する 1 つ以上のメソッドを定義します。

//非同期DAOクエリを作成するの詳細はこちら
//https://developer.android.com/training/data-storage/room/async-queries?hl=ja

@Dao/**/
interface TaskDao {


    //  @Insert アノテーションを使用すると、
    //  データベース内の適切なテーブルにパラメータを挿入するメソッドを定義できます。
    @Insert

    //  ワンショット クエリは、1 回だけ実行され、実行時にデータのスナップショットを取得するデータベース オペレーションです。非同期ワンショット クエリの例を次に示します。
    suspend fun insertTask(task: Task)

    //    @Queryアノテーションを使用すると、SQL ステートメントを記述して
    //    DAOメソッドとして公開できます。
    //    これらのクエリメソッドは、アプリのデータベースからデータをクエリする場合や、
    //    より複雑な挿入、更新、削除を行う必要がある場合に使用できます。
    @Query("SELECT * FROM Task")

    //    オブザーバブルクエリは、クエリで参照されるテーブルが変更されるたびに
    //    新しい値を出力する読み取りオペレーションです。
    //    使用方法としては、基となるデータベースのアイテムが挿入、更新、削除されたときに、
    //    表示されているアイテムのリストを最新の状態に保つことが挙げられます。
    fun loadAllTasks():Flow<List<Task>>

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

}