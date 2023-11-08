package com.example.myfirtappwithjetpackcompose.ui.view

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.SensorDoor
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun Animations() {
    Column {
        var showBox by rememberSaveable { mutableStateOf(true) }

        var firstColor by rememberSaveable { mutableStateOf(false) }

        val realColor = if (firstColor) Color.Red else Color.Blue

        if (showBox) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(realColor)
                    .clickable { firstColor = !firstColor },
            )

            Spacer(modifier = Modifier.size(200.dp))
        }

        var secondColor by rememberSaveable { mutableStateOf(false) }

        val realSecondColor by animateColorAsState(
            targetValue = if (secondColor) Color.Red else Color.Blue,
            animationSpec = tween(durationMillis = 2000),
            finishedListener = { showBox = false },
            label = "",
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(realSecondColor)
                .clickable { secondColor = !secondColor },
        )
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 200.dp,
        animationSpec = tween(1000),
        label = "",
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize },
    )
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Visible/Gone")
        }
        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(),
            exit = slideOutHorizontally(),
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Cyan),
            )
        }
        // MotionLayout()

        // sin animacion
        /*if (isVisible) {
            Box(modifier = Modifier.size(150.dp).background(Color.Cyan))
        }*/
    }
}

@Composable
fun CrossFadeAnimation() {
    var myComponentType: ComponentsType by rememberSaveable { mutableStateOf(ComponentsType.Text) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType, label = "") {
            when (it) {
                ComponentsType.Image -> Icon(
                    imageVector = Icons.Rounded.SensorDoor,
                    contentDescription = "icon",
                )

                ComponentsType.Text -> Text(text = "Probando animacion")
                ComponentsType.Box -> Box(
                    modifier = Modifier.size(150.dp).background(Color.LightGray),
                )

                ComponentsType.Error -> Text(text = "Ha ocurrido un error.")
            }
        }
    }
}

fun getComponentTypeRandom(): ComponentsType = when (nextInt(from = 0, until = 3)) {
    0 -> ComponentsType.Image
    1 -> ComponentsType.Text
    2 -> ComponentsType.Box
    else -> ComponentsType.Error
}

enum class ComponentsType() {
    Image, Text, Box, Error
}
