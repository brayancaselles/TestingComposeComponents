package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyBasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }

        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun MyAdvancedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        var completeValue by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
        )
        Text(text = completeValue)
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentrange by rememberSaveable { mutableStateOf(0f..10f) }
        RangeSlider(
            value = currentrange,
            onValueChange = { currentrange = it },
            valueRange = 0f..20f,
            steps = 19,
        )
        Text(text = "Valor inferior ${currentrange.start}")
        Text(text = "Valor superior ${currentrange.endInclusive}")
    }
}
