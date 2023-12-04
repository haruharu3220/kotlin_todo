package com.example.team_todo.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.team_todo.MainViewModel

@Composable
fun EditDialog(
    viewModel : MainViewModel = hiltViewModel(),
) {
//    DisposableEffect: クリーンアップが必要な作用
// https://developer.android.com/jetpack/compose/side-effects?hl=ja

//    キーが変化した後またはコンポーザブルが Composition から退場したときにクリーンアップする必要がある副作用については、DisposableEffect を使用します。DisposableEffect キーが変化した場合、コンポーザブルはその現在の作用を破棄（クリーンアップ）して、作用を再度呼び出すことによりリセットする必要があります。
//    たとえば、LifecycleObserver を使用し、Lifecycle イベントに基づいて分析イベントを送信する場合を考えます。Compose でこのイベントをリッスンするには、DisposableEffect を使用し、必要に応じてオブザーバーの登録と登録解除を行います。

    DisposableEffect(Unit){
        onDispose {
            viewModel.resetProperties()
        }
    }
    
    AlertDialog(
        //ダイアログの外側をタップした時
        onDismissRequest = { viewModel.isShowDialog = false },
        title = {
                Text(text = if(viewModel.isEditing)"タスク更新" else "タスク新規作成")
        },
        text = {
               Column() {
                   Text(text = "タイトル")
                   TextField(
                       value = viewModel.title,
                       onValueChange = { viewModel.title = it}
                   )
                   Text(text = "詳細")
                   TextField(
                       value = viewModel.description,
                       onValueChange = { viewModel.description = it}
                   )
               }
        },
        buttons = {
                  Row(
                      modifier = Modifier.padding(8.dp),
                      horizontalArrangement = Arrangement.Center
                  ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        modifier = Modifier.width(120.dp),
                        onClick = { viewModel.isShowDialog = false }
                    ) {
                        Text(text = "キャンセル")
                    }
                      Spacer(modifier = Modifier.width(10.dp))
                      Button(
                          modifier = Modifier.width(120.dp),
                          onClick = {
                              viewModel.isShowDialog = false
                              if(viewModel.isEditing){
                                viewModel.updateTask()
                                   }else{
                                  viewModel.createTask()
                              }
                          }
                      ) {
                          Text(text = "OK")
                      }

                  }
        },
    )
}