@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation(it)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable (PaddingValues) -> Unit) {
    MovieAppTheme {
        content(PaddingValues())
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MovieNavigation(it)
    }
}