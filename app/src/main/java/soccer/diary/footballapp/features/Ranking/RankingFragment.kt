package soccer.diary.footballapp.features.Ranking

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentRankingBinding
import soccer.diary.footballapp.features.LeagueDiary.LeagueViewModel
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.features.status.StatusbarAdapter
import soccer.diary.footballapp.model.*
import java.text.SimpleDateFormat
import java.util.*

class RankingFragment : DialogFragment(), onBackPressedListener {
    private val viewModel by viewModels<RankViewModel>()
    private lateinit var binding: FragmentRankingBinding
    private lateinit var adapter: RankAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentRankingBinding.inflate(layoutInflater)
        val view = binding.root
        loadingProgressBar = binding.root.findViewById(R.id.LoadingBar)
        loadingProgressBar.visibility = View.VISIBLE
        recyclerView = binding.rankRecyclerview
        adapter = RankAdapter(requireContext())
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(VerticalItemDecorator(20))

        arguments?.let {
            val code = it.getInt("code", 39)
            Log.d("code ", code.toString())
            viewModel.getRank(2023, code)
        }
        subscribeUI()

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(view)
        return builder.create()
    }

    private fun subscribeUI() {
        viewModel.RankResponse.observe(this) { data ->
            loadingProgressBar.visibility = View.INVISIBLE
            val standings = data.response[0].league.standings[0]
            for (standing in standings) {
                val rank = standing.rank
                Log.d("rank", rank.toString())
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
        dismiss()
    }
}
