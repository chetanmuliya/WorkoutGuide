package wg.cm.workoutguide.presentation.home_screen.program_stats_diet_frags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import wg.cm.workoutguide.R
import wg.cm.workoutguide.presentation.home_screen.ProgramListSection
import wg.cm.workoutguide.presentation.home_screen.model.Workout

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProgramFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ProgramListSection(
                    listOf(
                        Workout("test","teesttdesc", painterResource(id = R.drawable.home_workout), listOf("home","cardio","core")),
                        Workout("test","teesttdesc", painterResource(id = R.drawable.home_workout), listOf("home","cardio","core")),
                        Workout("test","teesttdesc", painterResource(id = R.drawable.home_workout), listOf("home","cardio","core"))
                    )
                )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProgramFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}