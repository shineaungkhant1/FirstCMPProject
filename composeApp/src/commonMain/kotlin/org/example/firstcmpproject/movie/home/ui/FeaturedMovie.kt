package org.example.firstcmpproject.movie.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.lalpalma_poster
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_SMALL
import org.example.firstcmpproject.core.MARGIN_XLARGE
import org.example.firstcmpproject.core.MARGIN_XXLARGE
import org.example.firstcmpproject.core.TEXT_REGULAR
import org.example.firstcmpproject.core.TEXT_REGULAR_3X
import org.example.firstcmpproject.movie.MovieActionButton
import org.jetbrains.compose.resources.painterResource

@Composable
fun FeaturedMovie(modifier: Modifier) {

    Box(
        modifier = modifier.fillMaxWidth().padding(
            top = MARGIN_MEDIUM_2,
            start = MARGIN_MEDIUM_2,
            end = MARGIN_MEDIUM_2,
        )
            .height(500.dp)
    ) {
        Image(
            painterResource(Res.drawable.lalpalma_poster),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(MARGIN_CARD_MEDIUM_2)),

            )

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Black,
                    )
                )
            ).fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM_2)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM_2),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Suspenseful",
                        color = Color.White,
                        fontSize = TEXT_REGULAR,
                        fontWeight = FontWeight.Medium
                    )
                    Surface(
                        color = Color.White,
                        shape = CircleShape,
                        modifier = Modifier.size(
                            MARGIN_SMALL
                        )
                    ) {

                    }
                    Text(
                        "Emotional",
                        color = Color.White,
                        fontSize = TEXT_REGULAR,
                        fontWeight = FontWeight.Medium
                    )
                    Surface(
                        color = Color.White,
                        shape = CircleShape,
                        modifier = Modifier.size(
                            MARGIN_SMALL
                        )
                    ) {

                    }
                    Text(
                        "Drama",
                        color = Color.White,
                        fontSize = TEXT_REGULAR,
                        fontWeight = FontWeight.Medium
                    )
                }
                FeatureMovieButtons()
            }

        }
    }
}



@Composable
fun FeatureMovieButtons() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(horizontal = MARGIN_MEDIUM_2)
    ) {
        MovieActionButton(
            backgroundColor = Color.White,
            iconVector = Icons.Default.PlayArrow,
            iconPainter = null,
            label = "Play",
            contentColor = Color.Black,
            modifier = Modifier.weight(1.0f),

        )
        MovieActionButton(
            backgroundColor = Color.DarkGray,
            iconVector= Icons.Default.Add,
            iconPainter = null,
            label = "My List",
            contentColor = Color.White,
            modifier = Modifier.weight(1.0f),

        )

    }
}


