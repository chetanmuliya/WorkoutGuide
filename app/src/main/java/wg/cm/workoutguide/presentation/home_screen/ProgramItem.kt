package wg.cm.workoutguide.presentation.home_screen

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.home_screen.model.Workout
import wg.cm.workoutguide.ui.theme.Grey
import wg.cm.workoutguide.ui.theme.Pink
import wg.cm.workoutguide.ui.theme.TextWhite

@Composable
fun programItem(workouts: Workout) {
    ImageCard(
        painterId = workouts.poster,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        title = workouts.name
    )
}

@Composable
fun ImageCard(
    painterId: Int,
    title: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painterResource(painterId),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 50f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.wrapContentSize().padding(10.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(
                            modifier = Modifier.wrapContentSize(),
                            shape = RoundedCornerShape(5.dp),
                            elevation = 5.dp
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 5.dp,end = 5.dp),
                                text = "Cardio",
                                style = TextStyle(
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Medium,
                                    color = Pink,
                                    fontSize = 12.sp
                                )
                            )
                        }
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 5.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = 5.dp
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 5.dp,end = 5.dp),
                                text = "HIIT",
                                style = TextStyle(
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Medium,
                                    color = Pink,
                                    fontSize = 12.sp,
                                    letterSpacing = 0.2.sp
                                )
                            )
                        }
                    }
                    Text(
                        text = "We've created a high-impact 45 minutes workout sessions to jump start your fitness career",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Medium,
                            color = Grey,
                            fontSize = 12.sp,
                            letterSpacing = 0.2.sp
                        )
                    )
                }

            }
        }
    }
}

