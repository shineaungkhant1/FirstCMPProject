package org.example.firstcmpproject.movie.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(navigateToDetail : (Int) -> Unit = {}) {
    Scaffold(containerColor = Color.Black, topBar = {
        HomeAppBar()
    }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {

                MoveCategoriesSection(modifier = Modifier.padding(start = MARGIN_MEDIUM_2))
            }

            item {

                FeaturedMovie(modifier = Modifier.clickable(
                    onClick = {
                        navigateToDetail(1)
                    }
                ))
            }
            // Space
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }

            // Movies and Categories

            items(10) {
               CategoryLabelAndMovies(onTapMovie = navigateToDetail)
            }

        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}