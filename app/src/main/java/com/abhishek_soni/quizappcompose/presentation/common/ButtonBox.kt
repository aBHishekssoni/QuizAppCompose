package com.abhishek_soni.quizappcompose.presentation.common

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.util.Dimens
import com.abhishek_soni.quizappcompose.presentation.util.Dimens.MediumTextSize

@Preview
@Composable
private fun ButtonBoxPreview() {
    ButtonBox(
        text = "Next",
        padding = Dimens.SmallPadding,
        fraction = 1f,
        onClick = {}
    )
}

@Composable
fun ButtonBox(
              text: String,
              padding: Dp,
              containerColor: Color = colorResource(id = R.color.blue_grey),
              borderColor: Color = colorResource(id = R.color.blue_grey),
              textColor: Color = colorResource(id = R.color.black),
              fontSize: TextUnit = MediumTextSize,
              fraction: Float = 1f,
              onClick:() -> Unit,
) {
    Box (
        modifier = Modifier
            .padding(padding)
            .border(5.dp, borderColor, RoundedCornerShape(Dimens.LargeCornerRadius))
            .fillMaxWidth(fraction)
            .clickable { onClick() }
            .height(Dimens.MidiumBoxHeight)
            .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
            .background(containerColor),


        contentAlignment = Alignment.Center
    ){
        Text(text = text, fontSize = fontSize,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold), color = textColor)

    }

}