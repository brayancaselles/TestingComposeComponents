package com.example.myfirtappwithjetpackcompose.ui.view.challenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myfirtappwithjetpackcompose.R

@Preview
@Composable
fun ChallengeTwitter() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF171C28))
            .padding(16.dp),
    ) {
        val (imageProfile, textUser, textNickName, textHours, textDescription, imagePrincipal, icons, iconDots, divider) = createRefs()

        var chat by remember { mutableStateOf(false) }
        var rt by remember { mutableStateOf(false) }
        var like by remember { mutableStateOf(false) }

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "image profile",
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
                .constrainAs(imageProfile) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
        )

        Text(
            "Brayan",
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier.constrainAs(textUser) {
                start.linkTo(imageProfile.end, margin = 16.dp)
                top.linkTo(imageProfile.top)
            },
        )
        Text(
            "@BrayanCaselles",
            color = Color.Gray,
            modifier = Modifier.constrainAs(textNickName) {
                start.linkTo(textUser.end, margin = 8.dp)
                top.linkTo(textUser.top)
            },
        )
        Text(
            "6h",
            color = Color.Gray,
            modifier = Modifier.constrainAs(textHours) {
                start.linkTo(textNickName.end, margin = 8.dp)
                top.linkTo(textNickName.top)
            },
        )

        Text(
            modifier = Modifier
                .width(285.dp)
                .constrainAs(textDescription) {
                    start.linkTo(textUser.start)
                    top.linkTo(textUser.bottom, margin = 8.dp)
                },
            text = "Descripción id w arga sobre dwf " + "Descripción larga sobre text" + "text Descripción larga sobre texto" + "Descripción larga dw dadsobre texto" + "Descripción larga dw dadsobre texto" + "Descripción larga dw dadsobre texto",
            color = Color.White,
        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "image Descripion",
            modifier = Modifier
                .width(280.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10))
                .constrainAs(imagePrincipal) {
                    top.linkTo(textDescription.bottom, margin = 8.dp)
                    start.linkTo(textDescription.start)
                },
            contentScale = ContentScale.Crop,
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "options",
            tint = Color.White,
            modifier = Modifier.constrainAs(iconDots) {
                top.linkTo(textHours.top)
                end.linkTo(parent.end)
                bottom.linkTo(textHours.bottom)
            },
        )

        Row(
            modifier = Modifier.constrainAs(icons) {
                top.linkTo(imagePrincipal.bottom, margin = 16.dp)
                start.linkTo(imagePrincipal.start)
            },
        ) {
            SocialIcons(
                modifier = Modifier.weight(1f),
                unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98),
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_filled),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98),
                    )
                },
                isSelected = chat,
            ) {
                chat = !chat
            }

            SocialIcons(
                modifier = Modifier.weight(1f),
                unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98),
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color(0xFF00FF27),
                    )
                },
                isSelected = rt,
            ) {
                rt = !rt
            }

            SocialIcons(
                modifier = Modifier.weight(1f),
                unSelectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = "",
                        tint = Color(0xFF7E8B98),
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like_filled),
                        contentDescription = "",
                        tint = Color(0xFFFF0000),
                    )
                },
                isSelected = like,
            ) {
                like = !like
            }
        }

        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(divider) {
                    top.linkTo(icons.bottom, margin = 20.dp)
                },
        )
    }
}

@Composable
fun SocialIcons(
    modifier: Modifier,
    unSelectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit,
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unSelectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7EBB9B),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 12.dp),
        )
    }
}
