package org.example.firstcmpproject.movie.details.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.TEXT_LARGE
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailScreen() {
    Scaffold(containerColor = Color.Black) {
        LazyColumn {
            item {
                DetailMovieImage()
            }

            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }
            item {
                DetailMovieLogo()
            }
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }
            item {
                Text(
                    "Gladiator",
                    color = Color.White,
                    fontSize = TEXT_LARGE,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                )
            }
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }
            item {
                MovieDetailInfo()
            }
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }
            item {
                MovieDetailButtons()
            }
        }
    }

}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen()
}