package com.abhishek_soni.quizappcompose.presentation.home.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.util.Dimens
@Preview
@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.HomeTopBoxHeight)
            .background(
                color = colorResource(id = R.color.dark_slate_blue),
                shape = RoundedCornerShape(
                    bottomEnd = Dimens.ExtraLargeCornerRadius,
                    bottomStart = Dimens.ExtraLargeCornerRadius
                ),
            )
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(top = Dimens.LargePadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(id = R.drawable.menu),
            contentDescription = "",
                modifier = Modifier.weight(1f)
                    .size(Dimens.MidiumiconSize),
                tint = colorResource(id = R.color.blue_grey)
            )
            Text(
                text = "Quiz App",
                modifier = Modifier.weight(3.5f),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontSize = Dimens.largeTextSize,
                color = colorResource(id = R.color.blue_grey)
            )
            Icon(
                painterResource(id = R.drawable.add_friend),
                contentDescription = "",
                modifier = Modifier.weight(1f)
                    .size(Dimens.MidiumiconSize),
                tint = colorResource(id = R.color.blue_grey)
            )
        }
    }
}