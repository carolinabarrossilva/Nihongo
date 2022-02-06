package com.carolinabarrossilva.nihongo.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carolinabarrossilva.nihongo.data.Term
import com.carolinabarrossilva.nihongo.ui.theme.NihongoTheme

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun TermCardPreview() {
    NihongoTheme {
        TermCard(Term.sample)
    }
}

@Composable
fun TermCard(
    term: Term,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    var wordWidth by remember { mutableStateOf(0.dp) }
    val lineWidth by derivedStateOf { wordWidth - 18.5.dp }

    Card(
        modifier
            .fillMaxWidth()
            .clickable { },
        shape = RectangleShape
    ) {


        Column(
            Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = term.word,
                Modifier.onGloballyPositioned { coordinates ->
                    wordWidth = with(density) {
                        coordinates.size.width.toDp()
                    }
                },
                fontSize = 36.sp
            )

            Spacer(
                Modifier
                    .width(lineWidth)
                    .height(2.dp)
                    .clip(CircleShape)
                    .background(Color(0x9E75B497))
            )

            Column {
                Text(
                    text = term.partOfSpeech,
                    Modifier
                        .alpha(0.5f)
                        .fillMaxWidth(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(
                    term.englishDefinitions.joinToString(separator = "; "),
                    Modifier.fillMaxWidth(),
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}