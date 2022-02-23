package wg.cm.workoutguide.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon as Icon

@Composable
fun MainHomeScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopBar()
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(10.dp)
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

@Preview
@Composable
fun ComposablePreview() {
    MainHomeScreen()
}