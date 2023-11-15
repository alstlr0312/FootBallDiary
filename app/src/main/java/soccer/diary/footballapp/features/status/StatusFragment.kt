package soccer.diary.footballapp.features.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.FragmentStatusBinding
import soccer.diary.footballapp.features.LeagueDiary.LeagueViewModel
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.model.*



class StatusFragment : Fragment(), StatusResponseObserver, onBackPressedListener {
    private lateinit var Nadapter: NationalAdapter
    private lateinit var NrecyclerView: RecyclerView
    private lateinit var binding: FragmentStatusBinding
    private val viewModel by viewModels<LeagueViewModel>()
    var code:Int = 0
    var backPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("Id", 0)
        }

       // viewModel.fixtures(code, this)

    }

    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }

    override fun onLineupResponseReceived(lineupsResponse: LineupsResponse) {
        TODO("Not yet implemented")
    }

    override fun onStatusResponseReceived(statusResponse: StatusResponse) {
        TODO("Not yet implemented")
    }

}