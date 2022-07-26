package wg.cm.workoutguide.domain.model

data class ExerciseListings(
    val name:String,
    val reps:String,
    val thumbnail: Int,
    val bodyPart: String
)