package org.example.firstcmpproject.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.gladiator_photo
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MOVIE_ITEM_HEIGHT
import org.example.firstcmpproject.core.MOVIE_ITEM_WIDTH
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieItem(movie: MovieVO?,onTapMovie : (Int) -> Unit) {
    AsyncImage(
        movie?.getFullMovieBackdropPath(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(width = MOVIE_ITEM_WIDTH, height = MOVIE_ITEM_HEIGHT)
            .clip(RoundedCornerShape(MARGIN_MEDIUM)).clickable(
                onClick = {
                    movie?.let { onTapMovie(it.id.toInt()) }
                }
            )

        )
}