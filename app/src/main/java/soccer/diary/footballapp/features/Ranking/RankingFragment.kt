package soccer.diary.footballapp.features.Ranking

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.FragmentRankingBinding
import soccer.diary.footballapp.features.LeagueDiary.LeagueViewModel
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.features.status.StatusbarAdapter
import soccer.diary.footballapp.model.*
import java.text.SimpleDateFormat
import java.util.*

class RankingFragment : Fragment(), onBackPressedListener {
    private val viewModel by viewModels<RankViewModel>()
    private lateinit var binding: FragmentRankingBinding
    var code:Int =39
    private lateinit var adapter: RankAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("code", 39)
            Log.d("code ",code.toString())
        }
        recyclerView= binding.rankRecyclerview
        recyclerView = binding.rankRecyclerview
        adapter = RankAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        viewModel.getRank(2023,code)
        Log.d("dfl","dsflkjsdfkljsdfk")
        subscribeUI()
    }

    private fun subscribeUI() {
        viewModel.RankResponse.removeObservers(viewLifecycleOwner)
        viewModel.RankResponse.observe(viewLifecycleOwner) { data ->
                val standings = data.response[0].league.standings[0]
                for (standing in standings) {
                    val rank = standing.rank
                    Log.d("rank",rank.toString())
                    val team = Ranks(
                        standing.team.id,
                        standing.team.name,
                        standing.team.logo
                    )
                    val points = standing.points
                    val goalsDiff = standing.goalsDiff
                    val stats = RankStats(
                        standing.all.played,
                        standing.all.win,
                        standing.all.draw,
                        standing.all.lose,
                        RankGoals(
                            standing.all.goals.home,
                            standing.all.goals.away
                        )
                    )
                    val rankStanding = RankStanding(rank, team, points, goalsDiff, stats)
                    adapter.addItem(rankStanding)
                }
        }
    }
    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }
}