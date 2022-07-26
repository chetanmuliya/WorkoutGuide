package wg.cm.workoutguide.presentation.workout_screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import wg.cm.workoutguide.R
import wg.cm.workoutguide.data.datastore.DataStorePreference
import wg.cm.workoutguide.presentation.home_screen.fontFamily
import wg.cm.workoutguide.ui.theme.*
import androidx.compose.foundation.layout.Box as Box

@ExperimentalMaterialApi
@Composable
@Destination
fun ExerciseScreen(
    symbol: String
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 12.dp,topEnd = 12.dp),
        sheetBackgroundColor = bottomSheetCharcoal,
        drawerScrimColor = Color.Black,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                BottomSheetContent(bottomSheetScaffoldState)
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Charcoal)
                .verticalScroll(rememberScrollState())
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
                                    Charcoal,
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
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Charcoal)
                    ) {

                        Text(
                            text = "Incline Bench Press",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontFamily,
                            color = TextWhite,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp, start = 15.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "12",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = fontFamily,
                                color = TextWhite,
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
                                color = TextWhite,
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
                                color = TextWhite,
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
                                .background(Charcoal)
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
            Spacer(modifier = Modifier.height(20.dp))
            setsCard(bottomSheetScaffoldState,coroutineScope)
            Spacer(modifier = Modifier.height(20.dp))
            setGuidanceVideo()
            //TestScreen()
        }
    }
}

/*@Composable
fun TestScreen() {
    val navCOn = rememberNavController()
    BackHandler(true,onBack = {
       // Log.d("TestScreen: ****", "TestScreen: **************")
        navCOn.navigateUp()
    })
}*/
@Composable
fun setGuidanceVideo() {
    Text(
        text = "How to perform this Exercise?  ",
        fontWeight = FontWeight.SemiBold,
        fontFamily = fontFamily,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        color = TextWhite,
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        modifier = Modifier.fillMaxWidth()
    )
}
@ExperimentalMaterialApi
fun openBottomSheet(bottomSheetScaffoldState: BottomSheetScaffoldState, coroutineScope: CoroutineScope){
    coroutineScope.launch {

        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
            bottomSheetScaffoldState.bottomSheetState.expand()
        } else {
            bottomSheetScaffoldState.bottomSheetState.collapse()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun setsCard(bottomSheetScaffoldState: BottomSheetScaffoldState, coroutineScope: CoroutineScope) {

    val context = LocalContext.current
    val dataStore = DataStorePreference(context)
    val set1RepsWeights = dataStore.getRepsWeight.collectAsState(initial = "")
    val set2RepsWeights = dataStore.getSet2RepsWeight.collectAsState(initial = "")
    val set3RepsWeights = dataStore.getSet3RepsWeight.collectAsState(initial = "")
    val set4RepsWeights = dataStore.getSet4RepsWeight.collectAsState(initial = "")

    Column(modifier = Modifier
        .fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    coroutineScope.launch {
                        dataStore.saveRepsWeightIndex(1)
                    }
                    openBottomSheet(bottomSheetScaffoldState, coroutineScope)
                },
            backgroundColor = lightCharcoal,
            shape = RoundedCornerShape(10.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.size(40.dp))
                {
                Canvas(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .padding(10.dp)
                ) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height

                    drawCircle(
                        color = TextWhite,
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 2,
                        style = Stroke(5F)
                    )
                }
                Text(
                    text = "1",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = TextWhite,
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                }
                Text(
                    text = if(set1RepsWeights.value!!.isEmpty()) "12" else set1RepsWeights.value!! ,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = Pink,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription ="add reps and sets",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    coroutineScope.launch {
                        dataStore.saveRepsWeightIndex(2)
                    }
                    openBottomSheet(bottomSheetScaffoldState, coroutineScope)
                },
            backgroundColor = lightCharcoal,
            shape = RoundedCornerShape(10.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.size(40.dp))
                {
                    Canvas(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .padding(10.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height

                        drawCircle(
                            color = TextWhite,
                            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                            radius = size.minDimension / 2,
                            style = Stroke(5F)
                        )
                    }
                    Text(
                        text = "1",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = fontFamily,
                        color = TextWhite,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = set2RepsWeights.value!!,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = Pink,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription ="add reps and sets",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    coroutineScope.launch {
                        dataStore.saveRepsWeightIndex(3)
                    }
                    openBottomSheet(bottomSheetScaffoldState, coroutineScope)
                },
            backgroundColor = lightCharcoal,
            shape = RoundedCornerShape(10.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.size(40.dp))
                {
                    Canvas(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .padding(10.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height

                        drawCircle(
                            color = TextWhite,
                            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                            radius = size.minDimension / 2,
                            style = Stroke(5F)
                        )
                    }
                    Text(
                        text = "1",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = fontFamily,
                        color = TextWhite,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = set3RepsWeights.value!!,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = Pink,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription ="add reps and sets",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    coroutineScope.launch {
                        dataStore.saveRepsWeightIndex(4)
                    }
                    openBottomSheet(bottomSheetScaffoldState, coroutineScope)
                },
            backgroundColor = lightCharcoal,
            shape = RoundedCornerShape(10.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.size(40.dp))
                {
                    Canvas(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .padding(10.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height

                        drawCircle(
                            color = TextWhite,
                            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                            radius = size.minDimension / 2,
                            style = Stroke(5F)
                        )
                    }
                    Text(
                        text = "1",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = fontFamily,
                        color = TextWhite,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = set4RepsWeights.value!!,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = Pink,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription ="add reps and sets",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }

        }
    }

}
