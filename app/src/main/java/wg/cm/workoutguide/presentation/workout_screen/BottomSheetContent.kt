package wg.cm.workoutguide.presentation.workout_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wg.cm.workoutguide.presentation.home_screen.fontFamily
import wg.cm.workoutguide.ui.theme.Pink
import wg.cm.workoutguide.ui.theme.TextWhite

@ExperimentalMaterialApi
@Composable
fun BottomSheetContent() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Icon(
            painter = painterResource(id = wg.cm.workoutguide.R.drawable.ic_baseline_cancel),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 10.dp, top = 10.dp),
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
            val replist = (1..50).toList()
            Spinner(
                replist,
                12,
                onItemSelected = {})
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
            val list = (10..300).toList()
            Spinner(
                list,
                100,
                onItemSelected = {})
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /*TODO*/ },
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
        dropDownModifier = Modifier.wrapContentSize(),
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
                Text(item.toString())

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