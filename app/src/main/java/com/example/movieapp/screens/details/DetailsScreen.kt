@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.movieapp.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow



@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?
) {
    
    val newMovieList = getMovies().filter {movie -> 
        movie.id == movieId
    }

    val mov= newMovieList.first()

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
                .padding(top = it.calculateTopPadding())
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState())
            ) {

//                MovieRow(movie = mov)
//
//                Spacer(modifier = Modifier.height(8.dp))
//                Divider()
//                Text(text = "Movie Images")
//
//                HorizontalImageView(mov)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    colors = CardDefaults.cardColors(Color.Black),
                    border = BorderStroke(1.dp, Color.DarkGray),
                    shape = RectangleShape
                ) {
                    Image(painter = rememberImagePainter(data = mov.images[0]),
                        contentDescription = "Movie Poster",
                        modifier = Modifier.fillMaxWidth())
                }
                Divider(modifier = Modifier.padding(3.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(10.dp),
                    shape = RectangleShape
                ) {
                    Column(modifier = Modifier.padding(3.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = mov.title,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(10.dp),
                    border = BorderStroke(1.dp, Color.DarkGray),
                ) {
                    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Plot: ",
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)
                        )
                        Text(
                            text = mov.plot,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                Divider(modifier = Modifier.padding(3.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(10.dp),
                    border = BorderStroke(1.dp, Color.DarkGray)
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black
                                )
                            ) {
                                append("Director: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            ) {
                                append(mov.director)
                            }
                        }, modifier = Modifier.padding(2.dp)
                        )
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black
                                )
                            ) {
                                append("Released: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(mov.year)
                            }
                        }, modifier = Modifier.padding(2.dp)
                        )
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black
                                )
                            ) {
                                append("Genre: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(mov.genre)
                            }
                        }, modifier = Modifier.padding(2.dp)
                        )
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black
                                )
                            ) {
                                append("Cast: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(mov.actors)
                            }
                        }, modifier = Modifier.padding(2.dp)
                        )
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black
                                )
                            ) {
                                append("Rating: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(mov.rating)
                            }
                        }, modifier = Modifier.padding(2.dp)
                        )
                    }
                }

                Divider(modifier = Modifier.padding(3.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(200.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    border = BorderStroke(1.dp, Color.DarkGray),
                    shape = RectangleShape
                ) {
                    Text(text = "Movie Images",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Black
                    )

                    HorizontalImageView(newMovieList = newMovieList)
                }

            }
        }


    }


}

@Composable
private fun HorizontalImageView(newMovieList: List<Movie>) {
    LazyRow() {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .size(200.dp),
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Image"
                )

            }

        }
    }
}