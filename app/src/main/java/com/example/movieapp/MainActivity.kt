@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent(it)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Movies"
                        )
                    },
                    modifier = Modifier.shadow(elevation = 5.dp),
                    colors = topAppBarColors(containerColor = Color.Magenta)
                )
            }
        ) {
            content(it)
        }
    }
}

@Composable
fun MainContent(
    paddingValues: PaddingValues,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Batman",
        "Harry Potter",
        "Barbie",
        "Lord Of The Rings",
        "Fight Club",
        "Se7en"
    )
) {
    Column(
        modifier = Modifier
            .padding(
                start=12.dp,
                top= paddingValues.calculateTopPadding()+12.dp,
                bottom=12.dp,
                end=12.dp
            )
    ) {
        LazyColumn(content = {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.d("Tag","MainContent: $movie")
                }
            }
        })

    }

}


@Composable
fun MovieRow(
    movie: String,
    onItemClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                       onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image")
            }
            Text(
                text = movie
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MainContent(it)
    }
}