package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myfirtappwithjetpackcompose.R

@Preview(showBackground = true)
@Composable
fun ShowAlertDialog() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "View Dialog")
        }
        MyConfirmationDialog(show = show, onDismiss = { show = false })
    }
}

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            title = { Text(text = "Título") },
            text = { Text(text = "Descripción del mensaje.") },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            },
        )
    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
        ) {
            Column(modifier = Modifier.background(Color.White).padding(24.dp).fillMaxWidth()) {
                Text(text = "Custom dialog")
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
        ) {
            Column(modifier = Modifier.background(Color.White).padding(24.dp).fillMaxWidth()) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "josemelegindo@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "martamelegindo@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "add new account", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier,
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(8.dp).size(40.dp).clip(CircleShape),
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(bottom = 24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by rememberSaveable { mutableStateOf("") }
                MyRadioButtonList(status) { status = it }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(modifier = Modifier.align(alignment = Alignment.End)) {
                    TextButton(onClick = { }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}
