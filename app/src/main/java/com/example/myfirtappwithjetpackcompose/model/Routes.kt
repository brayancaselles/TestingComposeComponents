package com.example.myfirtappwithjetpackcompose.model

sealed class Routes(val route: String) {
    object ScreenViewOne : Routes(route = "screenOne")
    object ScreenViewTwo : Routes(route = "screenTwo")
    object ScreenViewThree : Routes(route = "screenThree")
    object ScreenViewFour : Routes(route = "screenFour/{name}") {
        fun createRoute(name: String): String {
            return "screenFour/$name"
        }
    }

    object ScreenViewFive : Routes(route = "screenFive?name={name}") {
        fun createRoute(name: String): String = "screenFive?name=$name"
    }
}
