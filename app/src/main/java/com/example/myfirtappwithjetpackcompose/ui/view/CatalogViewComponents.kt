package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(text = "Hola text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Hola text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Hola text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "Hola text 4", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola text 5", modifier = Modifier.background(Color.Magenta))
    }
}

@Preview
@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End,
    ) {
        Text(text = "Hola text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Hola text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Hola text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "Hola text 4", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola text 5", modifier = Modifier.background(Color.Magenta))
        Text(text = "Hola text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Hola text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Hola text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "Hola text 4", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola text 5", modifier = Modifier.background(Color.Magenta))
        Text(text = "Hola text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Hola text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Hola text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "Hola text 4", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola text 5", modifier = Modifier.background(Color.Magenta))
        Text(text = "Hola text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Hola text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Hola text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "Hola text 4", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola text 5", modifier = Modifier.background(Color.Magenta))
    }
}

@Preview
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Blue),
        contentAlignment = Alignment.TopStart,
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Gray)
                .verticalScroll(rememberScrollState())
                .border(BorderStroke(1.dp, Color.Red))
                .padding(start = 5.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Probando los textos que son largos")
        }
    }
}

@Composable
fun MyTestSampleComponents() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Ejemplo 1 ")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Ejemplo 2 ")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Ejemplo 3 ")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Text(text = "Ejemplo 4 ")
        }
    }
}
