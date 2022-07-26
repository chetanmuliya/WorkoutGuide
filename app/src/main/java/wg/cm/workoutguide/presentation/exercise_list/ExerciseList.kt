package wg.cm.workoutguide.presentation.exercise_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import wg.cm.workoutguide.presentation.workout_screen.SingleExerciseViewModel

@Composable
@Destination
fun ExerciseList() {

        val viewModel = ExerciseListViewModel()
        Column(
                modifier = Modifier.fillMaxSize()
        ) {
             LazyColumn(
                 modifier = Modifier.fillMaxSize()
             ){
                items(viewModel.exercises.size){ item ->
                    val exercise = viewModel.exercises[item]
                    ExerciseItem(
                        exercise = exercise,
                        modifier = Modifier
                        .fillMaxWidth())
                    if (item < viewModel.exercises.size){
                        Divider(modifier = Modifier.padding(
                            horizontal = 16.dp
                        ))
                    }
                }

             }
        }       
}