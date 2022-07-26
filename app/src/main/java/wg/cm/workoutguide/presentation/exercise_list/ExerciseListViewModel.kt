package wg.cm.workoutguide.presentation.exercise_list

import androidx.lifecycle.ViewModel
import wg.cm.workoutguide.domain.model.ExerciseListings

class ExerciseListViewModel: ViewModel() {

    val exercises = listOf(ExerciseListings("incline dumble","12",0,"Chest"),
        ExerciseListings("Shoulder press","12",0,"Shoulder"),
        ExerciseListings("Flat presss","12",0,"Chest"),
        ExerciseListings("Cable fly","12",0,"Chest"),
        ExerciseListings("Triceps puch down","12",0,"Triceps"),
        ExerciseListings("Side Latereal","12",0,"Shoulder"),
        ExerciseListings("Shrugs","12",0,"Traps"),
        )

}