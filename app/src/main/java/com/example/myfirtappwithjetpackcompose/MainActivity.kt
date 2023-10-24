package com.example.myfirtappwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirtappwithjetpackcompose.ui.theme.MyFirtAppWithJetpackComposeTheme
import com.example.myfirtappwithjetpackcompose.ui.view.ShowAlertDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirtAppWithJetpackComposeTheme {
                Surface(
                    /*modifier = Modifier.fillMaxSize(),*/
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ShowAlertDialog()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirtAppWithJetpackComposeTheme {
    }
}
