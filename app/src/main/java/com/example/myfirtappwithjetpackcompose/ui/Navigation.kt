package com.example.myfirtappwithjetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.myfirtappwithjetpackcompose.model.Routes

@Composable
fun ScreenOne(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Cyan)) {
        Text(
            text = "Screen one",
            modifier = Modifier.align(Alignment.Center).clickable {
                navController.navigate(Routes.ScreenViewTwo.route)
            },
        )
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
        Text(
            text = "ScreenTwo",
            modifier = Modifier.align(Alignment.Center).clickable {
                navController.navigate(Routes.ScreenViewThree.route)
            },
        )
    }
}

@Composable
fun ScreenThree(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        Text(
            text = "Screen Three",
            modifier = Modifier.align(Alignment.Center).clickable {
                navController.navigate(Routes.ScreenViewFour.createRoute("Pedro"))
            },
        )
    }
}

@Composable
fun ScreenFour(navController: NavHostController, name: String) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
        Text(
            text = " Hola mi nombre es $name",
            modifier = Modifier.align(Alignment.Center).clickable {
                navController.navigate("screenFive")
            },
        )
    }
}

@Composable
fun ScreenFive(navController: NavHostController, name: String?) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow)) {
        Text(text = " Me llamo $name", modifier = Modifier.align(Alignment.Center))
    }
}
