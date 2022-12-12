package com.example.iteration1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iteration1.R
import com.example.iteration1.ui.theme.green700

// Bellow Login code
@Composable
fun MangroveScreen() {

    var username by remember { mutableStateOf("") }

    var password by rememberSaveable { mutableStateOf("") }


    Column() {

        Text(text = stringResource(id = R.string.app_name),
            color = green700,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp, bottom = 20.dp)
        )

        Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp, bottom= 10.dp)
        )

        EmailTextField(username = username, changed = { username = it })

        Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp, bottom= 10.dp, end = 20.dp)

        )

        PasswordTextField(password = password, changed = { password = it })

        LoginButton (){}

    }

}


@Composable
fun EmailTextField (username:String, changed: (String) -> Unit){
    TextField (
        value = username,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.enteremail)) },

        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(15.dp),

        )
}


@Composable
fun PasswordTextField(password: String, changed: (String) -> Unit ) {
    TextField(
        value = password,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterpass)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
//            .fillMaxWidth()
            .padding(start = 30.dp, top = 10.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(15.dp)
    )
}
@Composable
fun LoginButton(clicked: () -> Unit){
    Button(onClick = clicked,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = green700,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 30.dp, top = 10.dp)

    ) {
        Text(text = stringResource(id = R.string.loginbutton),

            textAlign = TextAlign.Center

        )
    }
}
