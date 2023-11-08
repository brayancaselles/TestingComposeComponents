package com.example.myfirtappwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirtappwithjetpackcompose.ui.theme.MyFirtAppWithJetpackComposeTheme
import com.example.myfirtappwithjetpackcompose.ui.view.CrossFadeAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*MyFirtAppWithJetpackComposeTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ScaffoldFun()
                }
            }*/
            Surface(
                color = MaterialTheme.colorScheme.background,
            ) {
                CrossFadeAnimation()
                /* Example navigation -->
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.ScreenViewOne.route,
                ) {
                    composable(Routes.ScreenViewOne.route) { ScreenOne(navigationController) }
                    composable(Routes.ScreenViewTwo.route) { ScreenTwo(navigationController) }
                    composable(Routes.ScreenViewThree.route) { ScreenThree(navigationController) }
                    composable(
                        Routes.ScreenViewFour.route,
                        arguments = listOf(navArgument("name") { type = NavType.StringType }),
                    ) { backStackEntry ->

                        val name = backStackEntry.arguments?.getString("name")

                        ScreenFour(
                            navigationController,
                            name!!,
                        )
                    }
                    composable(
                        Routes.ScreenViewFive.route,
                        arguments = listOf(navArgument("name") { defaultValue = "Pedro Pablo" }),
                    ) { backStackEntry ->
                        ScreenFive(
                            navController = navigationController,
                            name = backStackEntry.arguments?.getString("name"),
                        )
                    }
                }*/
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
