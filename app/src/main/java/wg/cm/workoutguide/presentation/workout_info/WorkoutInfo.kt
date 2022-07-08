package wg.cm.workoutguide.presentation.workout_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.destinations.ExerciseScreenDestination
import wg.cm.workoutguide.presentation.destinations.ProgramOverviewViewDestination
import wg.cm.workoutguide.presentation.destinations.WorkoutInfoDestination
import wg.cm.workoutguide.presentation.home_screen.fontFamily
import wg.cm.workoutguide.presentation.workout_screen.ExerciseScreen
import wg.cm.workoutguide.ui.theme.Pink
import wg.cm.workoutguide.ui.theme.TextWhite

@Composable
@Destination
fun WorkoutInfo(
    navigator: DestinationsNavigator,
    symbol: String
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.workout),
                contentDescription = "Menu",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
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
                            startY = 30f
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
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Push Pull Legs",
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        OverviewTabView {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> {
                ProgramOverviewView(symbol = "")
            }
            1 -> {
                ProgramScheduleView(symbol = "")
            }
        }

      }
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .align(Alignment.BottomCenter)) {
            Button(
                onClick = {
                    navigator.navigate(
                    ExerciseScreenDestination(""))
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)

            ) {
                Text(
                    text = "Start the Program"
                )
            }
        }
    }

}

@Composable
fun OverviewTabView(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val activeColor = Pink
    val inActiveColor = Color.LightGray
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.Transparent,
        contentColor = activeColor,
    ) {
        Tab(
            selected = selectedTabIndex==0,
            unselectedContentColor = inActiveColor,
            selectedContentColor = activeColor,
            onClick = {
                selectedTabIndex = 0
                onTabSelected(0)
            }
        ) {
            Text(
                text = "OVERVIEW",
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.2.sp
            )
        }
        Tab(
            selected = selectedTabIndex==1,
            unselectedContentColor = inActiveColor,
            selectedContentColor = activeColor,
            onClick = {
                selectedTabIndex = 1
                onTabSelected(1)
            }
        ) {
            Text(
                text = "SCHEDULE",
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.2.sp
            )
        }

    }
}