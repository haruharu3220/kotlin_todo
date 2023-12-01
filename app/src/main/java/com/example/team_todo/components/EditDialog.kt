package com.example.team_todo.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EditDialog() {
    AlertDialog(
        onDismissRequest = {/*Todo*/},
        title = {
                Text(text = "タスク新規作成")
        },
        text = {},
        buttons = {},
    )
}