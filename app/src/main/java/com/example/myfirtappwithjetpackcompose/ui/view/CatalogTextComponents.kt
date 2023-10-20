package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Text(text = "Hola text 1")
        Text(text = "Hola text 2", color = Color.Blue)
        Text(text = "Hola text 3", fontWeight = FontWeight.Bold)
        Text(text = "Hola text 4", fontWeight = FontWeight.ExtraBold)
        Text(text = "Hola text 5", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Hola text 6", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Hola text 7", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            text = "Hola text 8",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline),
                ),
            ),
        )
        Text(text = "Hola text 9", fontFamily = FontFamily.Cursive)
        Text(text = "Hola text 10", textDecoration = TextDecoration.LineThrough)
        Text(text = "Hola text 11", textDecoration = TextDecoration.Underline)
        Text(
            text = "Hola text 12",
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline),
            ),
        )
        Text(text = "Hola text 13", fontSize = 30.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        var myText by remember { mutableStateOf("") }
        TextField(value = myText, onValueChange = { myText = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text(text = "Introduce un valor") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyTextFieldOutline() {
    var myText by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Introduce un valor") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Cyan,
            ),
        )
    }
}
