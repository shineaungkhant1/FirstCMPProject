package org.example.firstcmpproject.movie.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.dolby_vision
import firstcmpproject.composeapp.generated.resources.message
import firstcmpproject.composeapp.generated.resources.spatial_audio
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_SMALL
import org.example.firstcmpproject.core.MARGIN_XXLARGE
import org.example.firstcmpproject.core.TEXT_REGULAR
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieDetailInfo(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM_2),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "2024",
            color = Color.White,
            fontSize = TEXT_REGULAR,
            fontWeight = FontWeight.Bold,

            )
        Box(
            modifier = Modifier
                .background(Color.Gray).border(
                    1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(MARGIN_SMALL)
                ).padding(all = MARGIN_SMALL)
        ) {
            Text(
                "18+",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,

                )
        }
        Text(
            "1h 59m",
            color = Color.White,
            fontSize = TEXT_REGULAR,
            fontWeight = FontWeight.Bold,

            )
        Image(
            painterResource(Res.drawable.dolby_vision),
            contentDescription = null,
            modifier = Modifier.size(MARGIN_XXLARGE),
            colorFilter = ColorFilter.tint(Color.White)

        )
        Box(
            modifier = Modifier
                .background(Color.Transparent).border(
                    2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(MARGIN_SMALL)
                ).padding(all = MARGIN_SMALL)
        ) {
            Text(
                "HD",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,

                )
        }
        Image(
            painterResource(Res.drawable.spatial_audio),
            contentDescription = null,
            modifier = Modifier.size(MARGIN_LARGE),
            colorFilter = ColorFilter.tint(Color.White)

        )
        Image(
            painterResource(Res.drawable.message),
            contentDescription = null,
            modifier = Modifier.size(MARGIN_LARGE),
            colorFilter = ColorFilter.tint(Color.White)

        )
    }

}