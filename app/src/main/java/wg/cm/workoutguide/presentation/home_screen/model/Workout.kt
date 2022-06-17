package wg.cm.workoutguide.presentation.home_screen.model

import androidx.compose.ui.graphics.painter.Painter

data class Workout(
    val name: String,
    val disc: String,
    val poster: Painter,
    val types: List<String>
)
