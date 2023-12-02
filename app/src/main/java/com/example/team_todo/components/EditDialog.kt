package com.example.team_todo.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditDialog() {
    AlertDialog(
        onDismissRequest = {/*Todo*/},
        title = {
                Text(text = "タスク新規作成")
        },
        text = {
               Column() {
                   Text(text = "タイトル")
                   TextField(value = "", onValueChange = {/*Todo*/})
                   Text(text = "詳細")
                   TextField(value = "", onValueChange = {/*Todo*/})
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
                        onClick = { /*TODO*/ }
                    ) {
                        Text(text = "キャンセル")
                    }
                      Spacer(modifier = Modifier.width(10.dp))
                      Button(
                          modifier = Modifier.width(120.dp),
                          onClick = { /*TODO*/ }
                      ) {
                          Text(text = "OK")
                      }

                  }
        },
    )
}