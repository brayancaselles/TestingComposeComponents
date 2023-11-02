package com.example.myfirtappwithjetpackcompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlue, boxYellow, boxMagenta, boxCyan, boxRed) = createRefs()
        Box(
            modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow) {
                bottom.linkTo(boxBlue.top)
                end.linkTo(boxBlue.start)
            },
        )
        Box(
            modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
        )
        Box(
            modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed) {
                top.linkTo(boxBlue.bottom)
                start.linkTo(boxBlue.end)
            },
        )
        Box(
            modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta) {
                bottom.linkTo(boxBlue.top)
                start.linkTo(boxBlue.end)
            },
        )
        Box(
            modifier = Modifier.size(125.dp).background(Color.Cyan).constrainAs(boxCyan) {
                top.linkTo(boxBlue.bottom)
                end.linkTo(boxBlue.start)
            },
        )
    }
}

@Composable
fun ConstraintGuideLine() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val starGuide = createGuidelineFromStart(0.25f)

        Box(
            modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(starGuide)
            },
        )
    }
}

@Preview
@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(
            modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed) {
                start.linkTo(parent.start, margin = 16.dp)
            },
        )

        Box(
            modifier = Modifier.size(225.dp).background(Color.Yellow).constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            },
        )

        Box(
            modifier = Modifier.size(40.dp).background(Color.Green).constrainAs(boxGreen) {
                start.linkTo(barrier)
            },
        )
    }
}

@Preview
@Composable
fun ConstrainChain() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlue, boxYellow, boxRed) = createRefs()

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(parent.top, margin = 16.dp)
                },
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(boxYellow.start)
                    top.linkTo(boxYellow.bottom)
                },
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxBlue.start)
                    top.linkTo(boxBlue.bottom)
                },
        )

        createVerticalChain(boxYellow, boxBlue, boxRed, chainStyle = ChainStyle.Packed)
        // createHorizontalChain(boxYellow, boxBlue, boxRed, chainStyle = ChainStyle.Packed)
    }
}
