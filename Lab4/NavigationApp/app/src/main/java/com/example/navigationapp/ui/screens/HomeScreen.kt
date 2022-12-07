package com.example.navigationapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationapp.R

@Composable
fun HomeScreen() {

    Box() {
        Text(

            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(all=100.dp),
            text = stringResource(id = R.string.welcome),
            fontSize = 45.sp,
            color = MaterialTheme.colors.primary
            )

    }
}