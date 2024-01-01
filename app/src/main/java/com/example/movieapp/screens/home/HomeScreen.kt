@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(paddingValues: PaddingValues, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movies",
                        fontWeight = FontWeight.Bold
                    )
                },
                modifier = Modifier.shadow(elevation = 5.dp),
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Magenta)
            )
        }
    ) {
        MainContent(paddingValues = it,navController = navController)
    }
}

@Composable
fun MainContent(
    paddingValues: PaddingValues,
    navController: NavController,
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
                    //Log.d("Tag","MainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        })

    }

}