package org.example.firstcmpproject.movie.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.gladiator_photo
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.TEXT_LARGE
import org.jetbrains.compose.resources.painterResource

@Composable
fun CategoryLabelAndMovies(onTapMovie:(Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = Modifier.padding(top = MARGIN_MEDIUM_2).clickable(
            onClick = {
                onTapMovie(1)
            }
        )
    ) {
        Text(
            "Today's Top Picks",
            color = Color.White,
            fontSize = TEXT_LARGE,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)

        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
            contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2)
        ) {
            items(20) {
                Image(
                    painter = painterResource(Res.drawable.gladiator_photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 120.dp, height = 180.dp)
                        .clip(RoundedCornerShape(MARGIN_MEDIUM)),

                )
            }
        }
    }
}