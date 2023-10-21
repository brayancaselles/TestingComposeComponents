package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyCardView() {
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            elevation = CardDefaults.elevatedCardElevation(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Cyan,
                contentColor = Color.Blue,
            ),
            border = BorderStroke(2.dp, Color.Red),
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Example one")
                Text(text = "Example two")
                Text(text = "Example three")
            }
        }
        Surface(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            shape = RectangleShape,
            shadowElevation = 20.dp,
            color = Color.Cyan,
            contentColor = Color.Blue,
            border = BorderStroke(2.dp, Color.Red),
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Example one")
                Text(text = "Example two")
                Text(text = "Example three")
            }
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge {
                Text(text = "1")
            }
        },
        modifier = Modifier.padding(20.dp),
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
    }
}

@Preview(showBackground = true)
@Composable
fun MyDivider() {
    Divider(modifier = Modifier.fillMaxWidth().padding(20.dp), color = Color.Red, thickness = 2.dp)
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val characters = listOf("Goku", "Vegeta", "Trunks", "Gohan")

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            enabled = false,
            readOnly = true,
            onValueChange = { selectedText = it },
            modifier = Modifier.fillMaxWidth().clickable { expanded = true },
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
        ) {
            characters.forEach { character ->
                DropdownMenuItem(text = { Text(text = character) }, onClick = {
                    expanded = false
                    selectedText = character
                })
            }
        }
    }
}
