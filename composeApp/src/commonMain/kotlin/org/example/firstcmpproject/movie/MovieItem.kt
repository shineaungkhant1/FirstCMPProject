package org.example.firstcmpproject.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.gladiator_photo
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MOVIE_ITEM_HEIGHT
import org.example.firstcmpproject.core.MOVIE_ITEM_WIDTH
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieItem(onTapMovie : (Int) -> Unit) {
    Image(
        painter = painterResource(Res.drawable.gladiator_photo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(width = MOVIE_ITEM_WIDTH, height = MOVIE_ITEM_HEIGHT)
            .clip(RoundedCornerShape(MARGIN_MEDIUM)).clickable(
                onClick = {
                    onTapMovie(1)
                }
            )

        )
}