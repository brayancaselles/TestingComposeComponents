package com.example.myfirtappwithjetpackcompose.ui.view

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyComponentsButtonCatalog() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Button(
            onClick = {
                enabled = false
                Log.i("Example", "Clicl in button")
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Blue,
            ),
            border = BorderStroke(2.dp, Color.Cyan),
        ) {
            Text(text = "Pulsar")
        }

        OutlinedButton(
            onClick = {
                enabled = false
                Log.i("Example", "Clicl in button outlined")
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Red,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Cyan,
            ),
        ) {
            Text(text = "Pulsar outlined")
        }

        TextButton(onClick = { }) {
            Text(text = "Text Button")
        }
    }
}
