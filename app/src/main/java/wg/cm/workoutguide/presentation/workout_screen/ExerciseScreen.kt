package wg.cm.workoutguide.presentation.workout_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.home_screen.fontFamily
import wg.cm.workoutguide.ui.theme.Pink

@Composable
@Destination
fun ExerciseScreen(
    symbol: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.incline_bench_press),
                contentDescription = "Menu",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(370.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent
                            ),
                            startY = 5f
                        )
                    )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(38.dp)
                        .padding(start = 15.dp, top = 15.dp)
                )
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = "Plan Details",
                    fontStyle = FontStyle.Normal,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp)
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(topStart = 20.dp,topEnd = 20.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "12",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Color.Black,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .weight(1f)
                        )
                        Text(
                            text = "3",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Color.Black,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .weight(1f)
                        )
                        Text(
                            text = "60 sec",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(
                            text = "Reps",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Pink,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text(
                            text = "Sets",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Pink,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text(
                            text = "Rest",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = Pink,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
            }


        }
    }
}