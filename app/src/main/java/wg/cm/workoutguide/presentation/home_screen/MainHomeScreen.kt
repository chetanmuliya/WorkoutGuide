package wg.cm.workoutguide.presentation.home_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentManager
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.destinations.StatsViewDestination
import wg.cm.workoutguide.presentation.destinations.WorkoutInfoDestination
import wg.cm.workoutguide.presentation.home_screen.model.Workout
import wg.cm.workoutguide.presentation.home_screen.util.workoutList
import wg.cm.workoutguide.ui.theme.Blue500
import wg.cm.workoutguide.ui.theme.Grey
import wg.cm.workoutguide.ui.theme.Pink
import wg.cm.workoutguide.ui.theme.TextWhite
import androidx.compose.material.Icon as Icon

val fontFamily = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_meduim, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight)
)

@ExperimentalMaterialApi
@Composable
@Destination(start = true)
fun MainHomeScreen(
    navigator: DestinationsNavigator
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(TextWhite)) {
        TopBar()
        DateColumn()
        //bottombar
        val sectionState = remember { mutableStateOf(BarSection.Home) }
        val navItems = BarSection.values().toList()


        ProgramTabView{
            selectedTabIndex = it
        }
        Scaffold(
            backgroundColor = TextWhite,
            bottomBar = {
                BottomBar(
                    items = navItems,
                    currentSection = sectionState.value,
                    onSectionSelected = { sectionState.value = it },
                )
            }) { innerPadding ->

            val modifier = Modifier.padding(innerPadding)
            Crossfade(
                modifier = modifier,
                targetState = sectionState.value
            ) { section ->
                when (section) {
                    //BarSection.Home -> HomeView(actions)
                    //BarSection.List -> VegetableListView(actions)
                }
            }
            ProgramListSection(workouts = workoutList,navigator = navigator)
        }


        when(selectedTabIndex){
            0 -> {
                //find
            }
            1 -> {
               //
            }
            2 -> {
                //Toast.makeText(ctx,"Hello Diet",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 24.dp, end = 24.dp)
    ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "User",
                modifier = Modifier
                    .size(32.dp)
            )
    }
}

@Composable
fun DateColumn(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.Start,
        verticalArrangement  = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Feb 24,2022", modifier = Modifier.padding(start = 24.dp,end = 24.dp,top = 30.dp),
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.2.sp
        )
        Text(
            text = "Always remember that You Are Absolutely Unique Just live Everyone Else",
            modifier = Modifier.padding(start = 24.dp,end = 24.dp),
            color = Color.LightGray,
            fontSize = 14.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.2.sp
        )
    }
}

@Composable
fun ProgramTabView(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val activeColor = Pink
    val inActiveColor = Color.LightGray
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .padding(top = 30.dp)
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
                text = "Program",
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
                text = "Stats",
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.2.sp
            )
        }
        Tab(
            selected = selectedTabIndex==2,
            unselectedContentColor = inActiveColor,
            selectedContentColor = activeColor,
            onClick = {
                selectedTabIndex = 2
                onTabSelected(2)
            }
        ) {
            Text(
                text = "Diet",
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.2.sp
            )
        }
        Tab(
            selected = selectedTabIndex==3,
            unselectedContentColor = inActiveColor,
            selectedContentColor = activeColor,
            onClick = {
                selectedTabIndex = 3
                onTabSelected(3)
            }
        ) {
            Text(
                text = "Community",
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.2.sp
            )
        }
    }
}

@Composable
fun ProgramListSection(
    workouts: List<Workout>,
    modifier: Modifier= Modifier,
    navigator: DestinationsNavigator
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 50.dp)
            .fillMaxWidth()
    ){
        items(workouts.size){
            programItem(
                workouts[it],
                modifier = Modifier.clickable {
                    navigator.navigate(
                        WorkoutInfoDestination("JJ")
                    )
                }
            )
        }
    }
}


