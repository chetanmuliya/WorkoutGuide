package wg.cm.workoutguide.presentation.home_screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import wg.cm.workoutguide.R
import wg.cm.workoutguide.ui.theme.Pink

@ExperimentalMaterialApi
@Composable
fun BottomBar(
    items: List<BarSection>,
    currentSection: BarSection,
    onSectionSelected: (BarSection) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(Pink)
    ){
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}

enum class BarSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Home(R.drawable.ic_menu, R.drawable.ic_menu),
    List(R.drawable.ic_menu, R.drawable.ic_menu),
    ShoppingCart(R.drawable.ic_menu, R.drawable.ic_menu),
    Profile(R.drawable.ic_user, R.drawable.ic_user),
}