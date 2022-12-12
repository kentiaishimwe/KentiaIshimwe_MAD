package com.example.iteration1.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.iteration1.R
import com.example.iteration1.model.FarmerRegistration
import com.example.iteration1.model.RegistrationViewModel
import com.example.iteration1.myapp
import com.example.iteration1.ui.theme.Iteration1Theme
import com.example.iteration1.ui.theme.green700

// Registration page code below

@Composable
fun RegistrationScreen() {
    val viewModel : RegistrationViewModel = viewModel()
    val context = LocalContext.current

    Scaffold(
        backgroundColor = MaterialTheme.colors.surface,

        content = {

            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                )
            )
            {

                items(viewModel.farmersList, key={item ->  item.name}){item -> UserRegistration(user = item, context = context, {} )}

            }
            }

    )
}


//    Column() {
//
//
//
//        Text(text = stringResource(id = R.string.name),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//        )
//
//        NameTextField(name = name, changed = { name = it })
//
//
//        Text(text = stringResource(id = R.string.phone_no),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//
//        PhoneTextField(phone_number = phone_number, changed = { phone_number = it })
//
//
//        Text(text = stringResource(id = R.string.location),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//        LocationTextField(location = location, changed = { location = it })
//
//
//        Text(text = stringResource(id = R.string.crops),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//        CropsTextField(crops = crops, changed = { crops = it })
//
//
//
//        Text(text = stringResource(id = R.string.Email),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//        emailTextField(email = email, changed = { email = it })
//
//
//        Text(text = stringResource(id = R.string.Password),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//        PasswTextField(password = passw, changed = { passw = it })
//
//
//        Text(text = stringResource(id = R.string.confpassw),
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(start = 30.dp)
//
//        )
//        ConfirmPasswTextField(confpassword = confpassw, changed = { confpassw = it })
//
//        RegisterButton() {}
//
//    }
//}


@Composable
fun UserRegistration(user: FarmerRegistration, context: Context, clicked: () -> Unit){
    var nameTextField by remember { mutableStateOf("") }
    var phoneTextField by remember { mutableStateOf("") }
    var locationTextField by remember { mutableStateOf("") }
    var cropsTextField by remember { mutableStateOf("") }
    var emailTextField by remember { mutableStateOf("") }
    var passwTextField by remember { mutableStateOf("") }
    var confpasswTextField by remember { mutableStateOf("") }


    Column(modifier = Modifier
            .padding(start = 30.dp, top = 10.dp),

    ) {
        TextField(
            value = user.name,
            onValueChange = { nameTextField = it },
            label = { Text(text = stringResource(id = R.string.name)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp),
        )


        TextField(
            value = user.phone_number,
            onValueChange = { phoneTextField = it },
            label = { Text(text = stringResource(id = R.string.phone_no)) },
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp),
        )

        TextField(
            value = user.location,
            onValueChange = { locationTextField = it },
            label = { Text(text = stringResource(id = R.string.location)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp)
        )



        TextField(
            value = user.crops,
            onValueChange = { cropsTextField = it },
            label = { Text(text = stringResource(id = R.string.crops)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp)
        )


        TextField(
            value = user.email,
            onValueChange = { emailTextField = it },
            label = { Text(text = stringResource(id = R.string.enteremail)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp)
        )

        TextField(
            value = user.passw,
            onValueChange = { passwTextField = it },
            label = { Text(text = stringResource(id = R.string.enterpass)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp)
        )

        TextField(
            value = user.confpassw,
            onValueChange = { confpasswTextField = it },
            label = { Text(text = stringResource(id = R.string.confpassw)) }
//        modifier = Modifier
//            .padding(start = 30.dp, top = 10.dp),
//        shape = RoundedCornerShape(15.dp)
        )

        Button(onClick = clicked,
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = green700,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)

        ) {
            Text(text = stringResource(id = R.string.register),
                textAlign = TextAlign.Center

            )


        }

    }

}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    Iteration1Theme {
        RegistrationScreen()
    }
}



