package wg.cm.workoutguide.presentation.workout_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import wg.cm.workoutguide.data.datastore.DataStorePreference
import wg.cm.workoutguide.presentation.home_screen.fontFamily
import wg.cm.workoutguide.ui.theme.Pink
import wg.cm.workoutguide.ui.theme.TextWhite

@ExperimentalMaterialApi
@Composable
fun BottomSheetContent(bottomSheetScaffoldState: BottomSheetScaffoldState) {

    val context = LocalContext.current
    val dataStore = DataStorePreference(context)
    val coroutineScope = rememberCoroutineScope()
    var selectedRepText by remember { mutableStateOf("") }
    var selectedWeightText by remember { mutableStateOf("") }
    val repsWeightsIndex = dataStore.getRepsWeightIndex.collectAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Icon(
            painter = painterResource(id = wg.cm.workoutguide.R.drawable.ic_baseline_cancel),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 10.dp, top = 10.dp)
                .clickable {
                           coroutineScope.launch {
                               if (bottomSheetScaffoldState.bottomSheetState.isExpanded) {
                                   bottomSheetScaffoldState.bottomSheetState.collapse()
                               }
                           }
                },
            contentDescription ="drop down arrow"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Incline Bench Press",
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            color = TextWhite,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "Target reps: 12",
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            color = TextWhite,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Reps",
                fontWeight = FontWeight.SemiBold,
                fontFamily = fontFamily,
                color = TextWhite,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            val replist = (1..100).toList()
            Spinner(
                replist,
                12,
                onItemSelected = {
                    selectedRepText = it.toString()
                })
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Weights (kg)",
                fontWeight = FontWeight.SemiBold,
                fontFamily = fontFamily,
                color = TextWhite,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            val list = (10..200).toList()
            Spinner(
                list,
                100,
                onItemSelected = {
                    selectedWeightText = it.toString()
                })
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    if (repsWeightsIndex.value!! == 1)
                        dataStore.saveRepsWeight("$selectedWeightText kg x $selectedRepText reps")
                    if (repsWeightsIndex.value!! == 2)
                        dataStore.saveSet2RepsWeight("$selectedWeightText kg x $selectedRepText reps")
                    if (repsWeightsIndex.value!! == 3)
                        dataStore.saveSet3RepsWeight("$selectedWeightText kg x $selectedRepText reps")
                    if (repsWeightsIndex.value!! == 4)
                        dataStore.saveSet4RepsWeight("$selectedWeightText kg x $selectedRepText reps")
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            },
            border = BorderStroke(2.dp, Pink),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
        ) {
            Text(text = "SAVE")
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun Spinner(
    availableQuantities: List<Int>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    Spinner(
        modifier = Modifier.wrapContentSize(),
        dropDownModifier = Modifier
            .wrapContentSize()
            .height(200.dp),
        items = availableQuantities,
        selectedItem = selectedItem,
        onItemSelected = onItemSelected,
        selectedItemFactory = { modifier, item ->
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .wrapContentSize()
                    .background(Pink),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item)

                Icon(
                    painter = painterResource(id = wg.cm.workoutguide.R.drawable.ic_arrow_drop_down),
                    contentDescription ="drop down arrow"
                )
            }
        },
        dropdownItemFactory = { item, _ ->
            Text(text = item.toString())
        }
    )
}