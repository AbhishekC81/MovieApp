@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.screens.home.MainContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, 
                  movieData: String?
) {

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
                navigationIcon = {
                                 IconButton(onClick = {
                                     navController.popBackStack()
                                 }) {
                                     Icon(imageVector = Icons.Default.ArrowBack,
                                         contentDescription = "Arrow Back",
                                         tint = MaterialTheme.colorScheme.onPrimary
                                     )
                                 }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Magenta)
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movieData.toString(),
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(23.dp))
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Go Back")
                }
            }
        }


    }


}