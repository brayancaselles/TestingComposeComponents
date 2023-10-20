package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.myfirtappwithjetpackcompose.ui.CheckInfo

@Composable
fun MySwitchComponent() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.LightGray,
            uncheckedBorderColor = Color.Black,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Blue,
            checkedBorderColor = Color.DarkGray,
            disabledUncheckedThumbColor = Color.Red,
            disabledUncheckedTrackColor = Color.LightGray,
            disabledUncheckedBorderColor = Color.Black,
            disabledCheckedThumbColor = Color.Green,
            disabledCheckedTrackColor = Color.Blue,
            disabledCheckedBorderColor = Color.DarkGray,
        ),
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.Cyan,
            ),
        )

        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = state, onCheckedChange = { state = !state })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Example Checkbox with text")
        }
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Example Checkbox with text")
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyExampleCheckList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start,
    ) {
        val myOptions =
            getOptions(
                titles = listOf(
                    "Goku",
                    "Krilin",
                    "Vegeta",
                    "Trunks",
                    "Piccolo",
                    "Gohan",
                    "Majin Buu",
                ),
            )
        myOptions.forEach {
            MyCheckBoxWithTextCompleted(it)
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus -> status = newStatus },
        )
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton() {
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Cyan,
            ),
            onClick = { },
        )
        Text(text = "Example one")
    }
}

@Composable
fun MyStateHoistingRadioButton() {
    var selected by rememberSaveable { mutableStateOf("Goku") }
    MyRadioButtonList(selected, onItemSelected = { selected = it })
}

@Composable
fun MyRadioButtonList(nameCharacter: String, onItemSelected: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            RadioButton(
                selected = nameCharacter == "Goku",
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Blue,
                    unselectedColor = Color.Green,
                    disabledSelectedColor = Color.Cyan,
                ),
                onClick = { onItemSelected("Goku") },
            )
            Text(text = "Goku")
            RadioButton(
                selected = nameCharacter == "Vegeta",
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Blue,
                    unselectedColor = Color.Green,
                    disabledSelectedColor = Color.Cyan,
                ),
                onClick = { onItemSelected("Vegeta") },
            )
            Text(text = "Vegeta")
            RadioButton(
                selected = nameCharacter == "Trunks",
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Blue,
                    unselectedColor = Color.Green,
                    disabledSelectedColor = Color.Cyan,
                ),
                onClick = { onItemSelected("Trunks") },
            )
            Text(text = "Trunks")
            RadioButton(
                selected = nameCharacter == "Gohan",
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Blue,
                    unselectedColor = Color.Green,
                    disabledSelectedColor = Color.Cyan,
                ),
                onClick = { onItemSelected("Gohan") },
            )
            Text(text = "Gohan")
        }
    }
}
