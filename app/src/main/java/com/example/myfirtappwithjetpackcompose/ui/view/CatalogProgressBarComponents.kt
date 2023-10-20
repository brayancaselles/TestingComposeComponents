package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(40.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Cyan, strokeWidth = 7.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 50.dp),
                color = Color.Black,
                trackColor = Color.Cyan,
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Click para cargar contenido.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyProgressAdvance() {
    var showLoading by rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(progress = showLoading)

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Button(onClick = {
                if (showLoading < 1f) {
                    showLoading += 0.1f
                }
            }) {
                Text(text = "Incrementar")
            }
            Button(onClick = {
                if (showLoading >= 0.1f) {
                    showLoading -= 0.1f
                }
            }) {
                Text(text = "Reducir")
            }
        }
    }
}
