package com.abhishek_soni.quizappcompose.presentation.quiz.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek_soni.quizappcompose.R
import com.abhishek_soni.quizappcompose.presentation.common.QuizOption
import com.abhishek_soni.quizappcompose.presentation.quiz.QuizState
import com.abhishek_soni.quizappcompose.presentation.util.Dimens


//@Preview
//@Composable
//private fun QuizInterfacePerview() {
//    QuizInterface(
//        onOptionSelect = {},
//
//        qNumber = 1
//    )
//}

@Composable
fun QuizInterface(modifier: Modifier = Modifier,
                  onOptionSelect: (Int) -> Unit,
                  quizState: QuizState,
                  qNumber: Int,
                  ) {
    val question = quizState.quiz?.question!!.replace("&quot;", "\"").replace("&#039;", "\'")
    Box (
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.wrapContentSize()) {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "$qNumber.",
                    color = colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.SmallTextSize

                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = question,
                    color = colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.SmallTextSize

                )
            }
            Spacer(modifier = Modifier.height(Dimens.LargeSpaceHeight))

            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ) {
                val options = listOf(
                    "A" to quizState.shuffledOptions[0].replace("&quot;", "\"").replace("&#039;", "\'"),
                    "B" to quizState.shuffledOptions[1].replace("&quot;", "\"").replace("&#039;", "\'"),
                    "C" to quizState.shuffledOptions[2].replace("&quot;", "\"").replace("&#039;", "\'"),
                    "D" to quizState.shuffledOptions[3].replace("&quot;", "\"").replace("&#039;", "\'"),

                )

                Column {
                    options.forEachIndexed { index, (optionNumber, optionText) ->
                        if (optionText.isNotEmpty()) {
                            QuizOption(
                                optionNumber = optionNumber,
                                options = optionText,
                                onOptionClick = { onOptionSelect(index) },
                                selected = quizState.selectedOption == index,
                                onUnselectOption = { onOptionSelect(-1) }
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.SmallSpaceHeight))
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpaceHeight))

            }

        }

    }
}