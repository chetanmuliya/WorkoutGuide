package wg.cm.workoutguide

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.ramcosta.composedestinations.DestinationsNavHost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import wg.cm.workoutguide.data.datastore.DataStorePreference
import wg.cm.workoutguide.presentation.NavGraphs
import wg.cm.workoutguide.presentation.home_screen.MainHomeScreen
import wg.cm.workoutguide.ui.theme.WorkoutGuideTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private lateinit var dataStore: DataStorePreference


    //@ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutGuideTheme {
                dataStore = DataStorePreference(this)
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //MainHomeScreen(ctx = this)
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        lifecycleScope.launch {
            dataStore.deleteRepsWeights()
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
