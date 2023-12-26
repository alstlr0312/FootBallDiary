package soccer.diary.footballapp.features.status

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import soccer.diary.footballapp.databinding.FragmentGetStatus1Binding
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.model.StatusResponse
import soccer.diary.footballapp.model.gameItem
import soccer.diary.footballapp.model.statusbaritem
import java.util.*



class GetStatus1Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus1Binding
    private lateinit var adapter: StatusbarAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStatus1Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val data = it.getSerializable("data") as StatusResponse
            //1.유효슛 2.슛 3.전체슛 4.막힌슛 5.박스내에서슛 6.박스밖에서슛 7.파울 8.코너킥 9.오프사이드
            //10.점유율 11.열로카드 12.레드카드 13.키퍼세입 14.전체패스 15.정확한패스 16.패스정확도
            val statusname = arrayOf("유효슛팅", "전체슛팅", "파울", "코너킥", "오프사이드", "점유율", "열로카드", "레드카드", "세이브", "전체패스", "패스정확도")
            recyclerView = binding.barRv
            adapter = StatusbarAdapter(requireContext())
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            val statics: Array<Array<Any>> = Array(2) { Array(16) { 0 } }

            val leagueflag=data.response[0].league.logo
            val hometeam=data.response[0].teams.home.name
            val awayteam=data.response[0].teams.away.name
            val round=data.response[0].league.round
            val referee=data.response[0].fixture.referee
            val stadium=data.response[0].fixture.venue.name
            val status = data.response[0].fixture.status.short
            Log.d("statsdf",status)
            Log.d("statsdf",hometeam)
            Log.d("statsdf",leagueflag)
            val NS="NS"
            if(status == NS){
                binding.roundTxt.text = round
                binding.refereename.text = referee
           binding.awayTeamName.text = awayteam
                binding.homeTeamName.text = hometeam
                Glide.with(requireContext()).load(Uri.parse(leagueflag)).into(binding.plLogoImg)
                binding.where.text = stadium
                binding.vs.text = "VS"
            }else{
                binding.awayTeamName.visibility = View.INVISIBLE
                binding.homeTeamName.visibility = View.INVISIBLE
                binding.plLogoImg.visibility = View.INVISIBLE
                binding.roundTxt.visibility = View.INVISIBLE
                binding.refereename.visibility = View.INVISIBLE
                binding.where.visibility = View.INVISIBLE
                binding.vs.visibility = View.INVISIBLE
                for (i in 0 until 2) {
                    for (j in 0 until 16) {
                        if(data.response[0].statistics[i].statistics[j] != null) {
                            statics[i][j] = data.response[0].statistics[i].statistics[j].value
                        }
                        else{

                        }
                    }
                }
                val indicesToRemove = listOf(1, 3, 4, 5, 14)
                val newArray = Array(2) { i ->
                    statics[i].filterIndexed { index, _ -> !indicesToRemove.contains(index) }
                        .toTypedArray()
                }
                for (i in 0..10) {
                    val homeScore = newArray[0][i] ?: 0
                    val awayScore = newArray[1][i] ?: 0
                    adapter.addItem(statusbaritem(statusname[i], homeScore, awayScore))
                    Log.d("chflkd", statusname[i])
                    Log.d("chflkd2", homeScore.toString())
                    Log.d("chflkd3", awayScore.toString())
                }
            }
        }
    }
}
