package com.example.navigationapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationapp.R

@Composable
fun LibraryScreen() {
    Column(modifier = Modifier
        .padding(16.dp)
        .padding(bottom = 20.dp)
        .verticalScroll(state = rememberScrollState())
    ) {

        Text(text = stringResource(id = R.string.animals),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            color = MaterialTheme.colors.primary
        )



        Image(painter = painterResource(id = R.drawable.dog1),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp, bottom = 40.dp)
                .size(200.dp))



        Image(painter = painterResource(id = R.drawable.dog3),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 40.dp)
                    .size(200.dp))



            Image(painter = painterResource(id = R.drawable.dog4),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 40.dp)
                    .size(200.dp))



//            Image(painter = painterResource(id = R.drawable.dog4),
//                contentDescription = null,
//                modifier = Modifier
//                    .padding(start = 20.dp, bottom = 40.dp)
//                    .size(200.dp))
        }

}



