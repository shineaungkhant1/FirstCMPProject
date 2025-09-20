package org.example.firstcmpproject.movie.details.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import org.example.firstcmpproject.core.DETAILS_BUTTON_ICON_SIZE
import org.example.firstcmpproject.core.MARGIN_40
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MOVIE_ITEM_HEIGHT
import org.example.firstcmpproject.core.TEXT_LARGE
import org.example.firstcmpproject.core.TEXT_REGULAR
import org.example.firstcmpproject.core.TEXT_SMALL
import org.example.firstcmpproject.core.TEXT_SMALL_2X
import org.example.firstcmpproject.movie.MovieItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailScreen(onTapMovie: (Int) -> Unit, onTapBack : () -> Unit) {
    Scaffold(containerColor = Color.Black) {
        LazyColumn {
            item {
                DetailMovieImage(onTapBack = onTapBack)
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

            item {
                Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
            }
            item {
                Text(
                    "A crowded airport. A dangerous suitcase. A mysterious criminal mastermind. On Christmas Eve, a security officer faces the ultimate travel nightmare.",
                    color = Color.White,
                    fontSize = TEXT_REGULAR,
                    modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                )
            }

            item {
                Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
            }

            item {
                Text(
                    "Cast: Taron Egerton, Sofia Carson, Jason Bateman ... more",
                    color = Color.DarkGray,
                    fontSize = TEXT_SMALL,
                    modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                )
            }

            item {
                Text(
                    "Director: Jaume Collet-Serra",
                    color = Color.DarkGray,
                    fontSize = TEXT_SMALL,
                    modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                )
            }

            item {
                Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(MARGIN_40),
                    modifier = Modifier.padding(horizontal = MARGIN_40)
                ) {
                    MovieDetailActionButton(Icons.Default.Add, "My List", modifier = Modifier)
                    MovieDetailActionButton(Icons.Default.ThumbUp, "Rate", modifier = Modifier)
                    MovieDetailActionButton(Icons.Default.Share, "SHare", modifier = Modifier)
                }
            }

            item {
                Spacer(modifier = Modifier.height(MARGIN_LARGE))
            }

            item {
                Text(
                    "More Like This",
                    color = Color.White,
                    fontSize = TEXT_LARGE,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                )
            }

            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }

            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
                    modifier = Modifier.height((MOVIE_ITEM_HEIGHT + MARGIN_CARD_MEDIUM_2) * 6),
                    verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                    horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                ) {
                    items((1..18).toList()) {
                        MovieItem(onTapMovie = onTapMovie)
                    }

                }
            }

        }

    }

}


@Composable
fun MovieDetailActionButton(icon: ImageVector, title: String, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(
                DETAILS_BUTTON_ICON_SIZE
            )
        )
        Text(title, color = Color.White, fontSize = TEXT_SMALL_2X)
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen(onTapMovie = {}, onTapBack = {})
}