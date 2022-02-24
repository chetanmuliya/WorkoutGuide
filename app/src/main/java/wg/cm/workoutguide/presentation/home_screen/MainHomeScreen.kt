package wg.cm.workoutguide.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wg.cm.workoutguide.R
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

@Composable
fun MainHomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopBar()
        DateColumn()
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .size(24.dp)
            )
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Menu",
                modifier = Modifier
                    .size(24.dp)
            )
    }
}

@Composable
fun DateColumn(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.Start,
        verticalArrangement  = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Feb 24,2022", modifier = Modifier.padding(horizontal = 5.dp),
            color = Color.Black, fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Always remember that You Are Absolutely Unique Just live Everyone Else", modifier = Modifier.padding(5.dp),
            color = Color.Gray, fontSize = 14.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    MainHomeScreen()
}