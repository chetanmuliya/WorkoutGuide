package wg.cm.workoutguide.presentation.workout_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.home_screen.fontFamily

@Composable
@Destination
fun ProgramOverviewView(
    symbol: String
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(start = 10.dp, end = 10.dp)
        .background(Color.Black)) {

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.ProgramOverview),
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.ProgramOverview),
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.ProgramOverview),
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.ProgramOverview),
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.ProgramOverview),
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            fontSize = 14.sp
        )


    }
}