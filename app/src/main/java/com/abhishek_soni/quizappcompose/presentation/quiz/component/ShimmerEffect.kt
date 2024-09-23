package com.abhishek_soni.quizappcompose.presentation.quiz.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.util.Dimens

@Preview
@Composable
fun ShimmerEffectQuizInterface(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row (
            modifier = Modifier.padding(Dimens.SmallPadding),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(1f)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(9f)
                    .shimmerEffect()
            )
        }
        Spacer(modifier = Modifier.height(Dimens.LargeSpaceHeight))
        Column (
            modifier = Modifier.padding(Dimens.SmallPadding)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.MidiumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.MidiumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.MidiumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.MidiumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpaceHeight))

            Row {
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                    .height(Dimens.MidiumBoxHeight)
                        .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.width(Dimens.SmallSpaceHeight))
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .height(Dimens.MidiumBoxHeight)
                        .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                        .shimmerEffect()
                )
            }

        }
    }
}


fun Modifier.shimmerEffect() = composed{
    val trasition = rememberInfiniteTransition(label = "")
    val alpha = trasition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(delayMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""

    ).value
    background(color = colorResource(id = R.color.blue_grey).copy(alpha = alpha))
}


