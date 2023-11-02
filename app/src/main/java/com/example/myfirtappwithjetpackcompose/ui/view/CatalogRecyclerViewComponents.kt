package com.example.myfirtappwithjetpackcompose.ui.view

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirtappwithjetpackcompose.R
import com.example.myfirtappwithjetpackcompose.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val list = listOf("Goku", "Vegeta", "Trunks")

    LazyRow() {
        item {
            Text(text = "Hello")
        }
        items(7) {
            Text(text = "Hello position $it")
        }
        items(list) {
            Text(text = "item position name $it")
        }
    }
    // LazyColumn(content = )
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { hero ->
            SuperHeroItem(superHero = hero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    // GridCells.Adaptive(100.dp) -> todos los items tienen el mismo tamaño
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)) {
        items(getSuperHeroes()) { hero ->
            SuperHeroItem(superHero = hero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroAdvanceView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(getSuperHeroes()) { hero ->
                SuperHeroItem(superHero = hero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp),
            visible = showButton,
        ) {
            Button(
                onClick = { coroutineScope.launch { rvState.animateScrollToItem(0) } },
            ) {
                Text(text = "Button")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroAdvanceStickyView() {
    val context = LocalContext.current
    val superHero = getSuperHeroes().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHero.forEach { (publiser, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publiser,
                    modifier = Modifier.fillMaxWidth().background(Color.Red),
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }

            items(mySuperHero) { hero ->
                SuperHeroItem(superHero = hero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SuperHeroItem(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.clickable { onItemSelected(superHero) },
    ) {
        Column {
            Image(
                painter = painterResource(id = superHero.image),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp,
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Wonder Woman", "Diana Prince", "DC", R.drawable.wonder_woman),
    )
}
