package com.example.team_todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.team_todo.Task

@Composable
fun TaskRow(
    task: Task,
    onClickRow: (Task) -> Unit,
    onClickDelete : (Task) -> Unit,
    ) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 5.dp,
    ){
        Row(
            modifier = Modifier
                .clickable { onClickRow(task) }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Checkbox(checked = task.isFinish, onCheckedChange = {
                task.isFinish != task.isFinish
            })
            Spacer(modifier = Modifier.weight(1f))
            Text(text = task.title)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onClickDelete(task) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "削除"
                )

            }

        }

    }
}



@Preview
@Composable
fun TaskRowPreview(){
    TaskRow(
        task = Task(
            title="プレビュー",
            description = "a",
            isFinish = false,
            deadLine = 0
            ),
        onClickRow = {},
        onClickDelete = {}
    )
}