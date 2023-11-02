package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SmsFailed
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldFun() {
    val scaffoldState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                MyDrawer {
                    scope.launch {
                        drawerState.close()
                    }
                }
            }
        },
        drawerState = drawerState,
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onclickIcon = {
                        scope.launch { scaffoldState.showSnackbar("Has pulsado $it") }
                    },
                    onClickDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                )
            },
            snackbarHost = { SnackbarHost(scaffoldState) },
            bottomBar = { BottomNavigationExample() },
            floatingActionButton = { Favorite() },
            floatingActionButtonPosition = FabPosition.Center,

        ) {
            it.calculateBottomPadding()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onclickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Toolbar") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Blue,
        ),
        /*navigationIcon = {
            IconButton(
                onClick = { onclickIcon("Back") },
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },*/
        navigationIcon = {
            IconButton(
                onClick = { onClickDrawer() },
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onclickIcon("Search") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                )
            }
            IconButton(onClick = { onclickIcon("Sms") }) {
                Icon(imageVector = Icons.Filled.SmsFailed, contentDescription = "Sms")
            }
        },
    )
}

@Composable
fun BottomNavigationExample() {
    var index by remember { mutableIntStateOf(0) }

    NavigationBar(containerColor = Color.Blue, contentColor = Color.White) {
        NavigationBarItem(
            selected = index == 0,
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home") },
            label = { Text(text = "Home") },
            onClick = { index = 0 },
            /*colors = NavigationBarItemDefaults.colors(
                unselectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
            ),*/
        )
        NavigationBarItem(
            selected = index == 1,
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text(text = "Favorite") },
            onClick = { index = 1 },
        )
        NavigationBarItem(
            selected = index == 2,
            icon = { Icon(imageVector = Icons.Default.PersonAdd, contentDescription = "Person") },
            label = { Text(text = "Add Person") },
            onClick = { index = 2 },
        )
    }
}

@Composable
fun Favorite() {
    FloatingActionButton(onClick = { }, containerColor = Color.Blue, contentColor = Color.White) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onClickClose: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Option 1",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 2",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 3",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 4",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 5",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 6",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
        Text(
            text = "Option 7",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                .clickable { onClickClose() },
        )
    }
}
