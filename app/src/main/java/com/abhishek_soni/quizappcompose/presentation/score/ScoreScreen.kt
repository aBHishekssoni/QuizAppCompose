package com.abhishek_soni.quizappcompose.presentation.score

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.nav_graph.Routes
import com.abhishek_soni.quizappcompose.presentation.util.Dimens
import com.abhishek_soni.quizappcompose.presentation.util.Dimens.largeTextSize
import com.airbnb.lottie.compose.LottieAnimation

@Composable
fun ScoreScreen(
    modifier: Modifier = Modifier,
    numOfQuestions: Int,
    numOfCorrectAns: Int,
    navController: NavController.Companion = NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = {
//                    goToHome(navController = NavController
                },
            ) {
                Icon(
                    painterResource(id = R.drawable.close), contentDescription = "close", tint = colorResource(id = R.color.blue_grey)
                )
            }

        }
        Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(Dimens.MediumCornerRadous))
                .background(colorResource(id = R.color.blue_grey)),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier.padding(
                    horizontal = Dimens.MediumPadding,
                    vertical = Dimens.MediumPadding
                ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
//                val coposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.congratulation))
                val annotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)){
                        append(" You attempted ")
                    }
                    withStyle(style = SpanStyle(color = Color.Blue)){
                        append("$numOfQuestions questions")
                    }
                    withStyle(style = SpanStyle(color = Color.Black)){
                        append(" and form that ")
                    }
                    withStyle(style = SpanStyle(color = Color.Green)){
                        append("$numOfCorrectAns answers ")
                    }
                    withStyle(style = SpanStyle(color = Color.Black)){
                        append("are correct")
                    }
                }
                val scorePercentage = calculatePercentage(numOfCorrectAns, numOfQuestions)
                LottieAnimation(
                    modifier = Modifier.size(Dimens.LargeLottieAnimSize),
                    composition = null,
                    iterations = 100
                )
                Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))
                Text(text = "Congratulations!", color = Color.Black, fontSize = Dimens.MediumTextSize,
                    style = MaterialTheme.typography.titleMedium,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))

                Text(text = "$scorePercentage% Score", color = colorResource(id = R.color.green),
                    fontSize = largeTextSize,
                    style = MaterialTheme.typography.titleMedium,fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))
                Text(text = "Quiz Completed Success. ", color = Color.Black, fontSize = Dimens.SmallTextSize,
                    style = MaterialTheme.typography.titleMedium,fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(Dimens.LargeSpaceHeight))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "Share with us : ", color = Color.Black, fontSize = Dimens.SmallTextSize,
                        style = MaterialTheme.typography.titleMedium,fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(Dimens.SmallSpaceHeight))
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.facebook), contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(Dimens.SmallSpaceHeight))
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.instagram), contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(Dimens.SmallSpaceHeight))
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.whatsapp), contentDescription = null
                    )


                }


            }
        }
    }

}
//fun goToHome(navController: NavController.Companion){
//    navController.navigate(Routes.HomeScreen.route){
//        popUpTo(Routes.ScoreScreen.route){
//            inclusive = true
//        }
//    }
//}

fun calculatePercentage(k: Int, n: Int): Double {
 require(k>=0 && k<=100){"Percentage should be between 0 and 100"}
    val percentage = (k.toDouble() / n.toDouble()) * 100.0
    return DecimalFormat("#.##").format(percentage).toDouble()
}
