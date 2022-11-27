package com.example.todo.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.R
import com.example.todo.model.ToDo
import com.example.todo.model.ToDoViewModel
import com.example.todo.model.sampleToDoData
import com.example.todo.ui.theme.ToDoTheme
import java.util.*

@Composable
fun ToDoScreen(){
    val viewModel : ToDoViewModel = viewModel()
    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }




    Scaffold (
        backgroundColor = MaterialTheme.colors.surface,
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true })
            {
                Icon( Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addTaskDialog(context, dismissDialog = {showDialog = false},
                    {viewModel.add(it)})
            }

            LazyColumn(contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 8.dp))
            {
                items(viewModel.taskList, key={item ->  item.id}){item -> TaskToDo(task = item, context, {viewModel.delete(it)}) }
            }
        }


    )

    }


@Composable
fun addTaskDialog(context: Context, dismissDialog:() -> Unit, addTask: (ToDo) -> Unit){
    var taskTextField by remember {
        mutableStateOf("")
    }
    var timeTextField by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.addTask), style = MaterialTheme.typography.h6)},
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = {Text (text=stringResource(id = R.string.taskname))}, value = taskTextField, onValueChange = {taskTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.tasktime))},value = timeTextField, onValueChange = {timeTextField=it})
            }
        },
        confirmButton = {
            Button(onClick = {
                if(taskTextField.isNotEmpty()) {
                    val newID = UUID.randomUUID().toString();
                    addTask(ToDo(newID, taskTextField, timeTextField))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.taskadded),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}

@Composable
fun deleteTaskDialog(context: Context, dismissDialog:() -> Unit, task: ToDo, deleteTask: (ToDo) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.delete), style = MaterialTheme.typography.h6)},
        confirmButton = {
            Button(onClick = {
                deleteTask(task)
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.taskdeleted),
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.yes))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskToDo(task: ToDo, context: Context, deleteTask: (ToDo) -> Unit )
{
    var showDeleteDialog by remember { mutableStateOf(false) }
    val checkedState = remember { mutableStateOf(false) }

   Card(elevation = 4.dp,
       shape = RoundedCornerShape(10.dp),
       backgroundColor = MaterialTheme.colors.secondary,
       contentColor = MaterialTheme.colors.onPrimary,
       border = BorderStroke(2.dp, color = MaterialTheme.colors.primaryVariant),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(context,
                            context.resources.getString(R.string.dotask) + " " + task.TaskName + " " + context.resources.getString(
                                R.string.time) + " " + task.time,
                            Toast.LENGTH_SHORT)
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )
       ) {
       Row(verticalAlignment = Alignment.CenterVertically) {
           Checkbox(checked = checkedState.value,
               onCheckedChange = { checkedState.value = it }
           )


           Column(modifier = Modifier.padding(16.dp)) {

               Text(text = task.TaskName, style = MaterialTheme.typography.h5)
               Text(text = task.time, style = MaterialTheme.typography.body1)
           }
       }
   }
    if (showDeleteDialog){
        deleteTaskDialog(context , dismissDialog = { showDeleteDialog = false }, task, deleteTask) }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoTheme(darkTheme = false) {
        ToDoScreen()
    }
}