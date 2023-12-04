/*
* 参考にしたサイト
* https://developer.android.com/jetpack/compose/layouts/basics?hl=ja
*
*
* */


package com.example.team_todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.team_todo.components.EditDialog
import com.example.team_todo.components.TaskList
import com.example.team_todo.ui.theme.Team_todoTheme
import dagger.hilt.android.AndroidEntryPoint

//import androidx.compose.material3.Scaffold


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Team_todoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
                        MainContent()
//                        Greeting("Android")
//                        Greeting("Test")
//                        MessageCard("メッセージカードです")
//                    }
//                    Row(verticalAlignment = Alignment.Bottom) {
//                        Image(
//                            painter = painterResource(id = R.drawable.neco),
//                            contentDescription = stringResource(id = R.string.neco_content_description),
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .size(200.dp)
//                                .clip(CircleShape)
//                        )
//                        Column() {
//                            Text("猫です")
//                            Text("かわいいです")
//                        }
//                    }

//                    Box {
//                        Column() {
//                            Image(
//                                painter = painterResource(id = R.drawable.neco),
//                                contentDescription = stringResource(id = R.string.neco_content_description),
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier
//                                .size(100.dp)
//                            )
//                            Image(
//                                painter = painterResource(id = R.drawable.dog),
//                                contentDescription = stringResource(id = R.string.neco_content_description),
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier
//                                    .size(100.dp)
//                            )
//                        }
//                        Icon(
//                            Icons.Rounded.ShoppingCart,
//                            contentDescription = stringResource(id = R.string.shopping_cart_content_desc)
//                        )
//                    }



                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Team_todoTheme {
        Greeting("Android")
    }
}

//https://developer.android.com/jetpack/compose/components/scaffold?hl=ja
@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel()){
    //コンポーネント内で変数を管理すると画面回転を行った時に
    //コンポーネントが再実行されて、初期化される→ダイアログが消える
//    val isShowDialog = remember { mutableStateOf(false) }
    if(viewModel.isShowDialog){
        EditDialog()
    }

        Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { viewModel.isShowDialog = true }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "タスクの新規作成")
        }

    }) {

//      https://developer.android.com/jetpack/compose/lists?hl=ja
        val tasks by viewModel.tasks.collectAsState(initial = emptyList())
            TaskList(
                tasks = tasks,
                onClickRow = {
                    viewModel.setEditingTask(it)
                    viewModel.isShowDialog = true
                },
                onClickDelete = {viewModel.deleteTask(it)},
            )
        }
    
}