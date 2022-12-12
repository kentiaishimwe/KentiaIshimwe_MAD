package com.example.iteration1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iteration1.model.FarmerRegistration
import com.example.iteration1.screens.RegistrationScreen
import com.example.iteration1.screens.MangroveScreen
import com.example.iteration1.ui.theme.Iteration1Theme
import com.example.iteration1.ui.theme.green200
import com.example.iteration1.ui.theme.green200
import com.example.iteration1.ui.theme.green700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent () {
            Iteration1Theme {
                // A surface container using the 'background' color from the theme
                myapp()
            }
        }
    }
}
@Composable
fun myapp()
{
    var Loginvaribale by remember{ mutableStateOf(false) }
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    if(shouldShowOnboarding)
    {
        OnboardingScreen(myfunction = {shouldShowOnboarding=false})
    }else if(shouldShowOnboarding==false && Loginvaribale==false)
    {
        Login(newfunction = { shouldShowOnboarding=true }, newfunction2 = {Loginvaribale=true})

    }
    else
    {
        register (newfunction = {Loginvaribale=false})
    }

}




@Composable
fun register(newfunction:()->Unit)
{

    Button(onClick =newfunction,
        colors = ButtonDefaults.buttonColors(backgroundColor = green700))
    {
        Text(stringResource(id = R.string.button2))
    }
    RegistrationScreen()
}

@Composable
fun Login(newfunction:()->Unit,newfunction2: () -> Unit)
{

 Row(modifier = Modifier
     .fillMaxSize()
     .background(color = MaterialTheme.colors.secondary))
 {
     Button(onClick =newfunction,
         colors = ButtonDefaults.buttonColors(backgroundColor = green700))
     {
         Text(stringResource(id = R.string.button2))
     }
     Spacer(modifier = Modifier.padding(horizontal = 10.dp))
     Button(onClick =newfunction2,
         colors = ButtonDefaults.buttonColors(backgroundColor = green700))
     {
         Text(stringResource(id = R.string.button3))
     }
 }

    MangroveScreen()

}

// Onboarding screen code below
@Composable
fun OnboardingScreen(myfunction:()->Unit) {
    // TODO: This state should be hoisted

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row()
        {
            Text(text=stringResource(id = R.string.logText), fontSize = 30.sp,fontWeight = FontWeight.Bold)
            Text(text=stringResource(id = R.string.logoText1), fontSize = 30.sp,fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Text(text=stringResource(id = R.string.solution), fontSize = 20.sp)
        Text(text=stringResource(id = R.string.solution2), fontSize = 20.sp)

        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Image(painter = painterResource(id = R.drawable.captureapp),
            contentDescription = stringResource(id = R.string.onboardImage),
            modifier = Modifier.size(450.dp)
        )

        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = green700),
            onClick = myfunction
        ) {
            Text(stringResource(id = R.string.ButtonText))
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    OnboardingScreen(myfunction ={})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Iteration1Theme {
        myapp()
    }
}