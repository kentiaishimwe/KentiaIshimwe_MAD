package com.example.navigationapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navigationapp.R


@Composable
fun SearchScreen() {

    var textFieldName by rememberSaveable { mutableStateOf("") }
    Column() {
        NameTextField(name = textFieldName, changed = {textFieldName=it})
        ButtonSearch({})



    }



}
@Composable
fun NameTextField(name: String, changed: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.field_search)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)

    )
}

@Composable
fun ButtonSearch(clicked: () -> Unit) {

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)


    ) {
        Button(onClick = clicked,
            modifier = Modifier
        )
        {
            Text(stringResource(id = R.string.search))

        }
    }
}