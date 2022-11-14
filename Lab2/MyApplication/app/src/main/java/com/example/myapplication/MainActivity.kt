package com.example.myapplication


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting() {

    var name by remember { mutableStateOf("") }
    var textFieldName by remember { mutableStateOf("") }
    var imageVar by remember {
        mutableStateOf(R.drawable.dogimage)
    }

    Column (horizontalAlignment = Alignment.CenterHorizontally)
    {

        GetImage(imageVar)
        NameTextField(name = textFieldName, changed = { textFieldName = it })

        SayName {
            name = textFieldName
            imageVar = R.drawable.catimage
        }


        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Magenta)

        ){
            TextMessage(AnimalName = name)
        }


    }
}


@Composable
fun SayName(clicked: () -> Unit){
    Button(onClick = clicked) {
        Text(stringResource(id = R.string.buttonMessage),
        modifier = Modifier
            .background(Color.Magenta))

    }
}


@Composable
fun NameTextField(name:String, changed: (String) -> Unit){
    TextField(
        value = name,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.label))},
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
        )
}


@Composable
fun TextMessage (AnimalName: String) {
    if (AnimalName.isNotEmpty()) {
        Text(
            text = stringResource(id = R.string.Description) + " " + AnimalName,
            color = Color.Cyan,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun GetImage (myImage: Int){

    val image = painterResource(id = myImage)

        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 40.dp)
                .size(190.dp)
                .clip(CircleShape)
        )

    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting()
    }
}