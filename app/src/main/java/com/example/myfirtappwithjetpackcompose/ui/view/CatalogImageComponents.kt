package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirtappwithjetpackcompose.R

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        alpha = 0.5f,
        modifier = Modifier.clip(RoundedCornerShape(20f)),
    )
}

@Preview(showBackground = true)
@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier.clip(CircleShape).border(5.dp, Color.LightGray, CircleShape),
    )
}

@Preview(showBackground = true)
@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icono", tint = Color.Blue)
}
