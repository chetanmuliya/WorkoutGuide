package wg.cm.workoutguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost
import wg.cm.workoutguide.presentation.home_screen.MainHomeScreen
import wg.cm.workoutguide.presentation.home_screen.NavGraphs
import wg.cm.workoutguide.ui.theme.WorkoutGuideTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    //@ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //MainHomeScreen(ctx = this)
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkoutGuideTheme {
        Greeting("Android")
    }
}*/
