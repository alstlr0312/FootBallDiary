package soccer.diary.footballapp.features.LeagueDiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.MyApplication
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentLeagueBinding
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.model.FixturesResponse
import soccer.diary.footballapp.model.ResponseObserver
import soccer.diary.footballapp.model.gameItem
import java.text.SimpleDateFormat
import java.util.*

class LeagueFragment : Fragment(), ResponseObserver {
    private lateinit var Nadapter: NationalAdapter
    private lateinit var NrecyclerView: RecyclerView
    private lateinit var binding: FragmentLeagueBinding
    private val viewModel by viewModels<LeagueViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val previousDate = calendar.time
        val previousDateString = dateFormat.format(previousDate)
        val dateString = dateFormat.format(currentDate)

        NrecyclerView = binding.LeagueRv
        Nadapter = NationalAdapter(requireContext())
        NrecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        NrecyclerView.adapter = Nadapter
        NrecyclerView.addItemDecoration(VerticalItemDecorator(20))
        arguments?.let {
            val code = it.getInt("code", 0)
            viewModel.fixtures(code, year, previousDateString, dateString, this)
        }

    }


    override fun onFixturesResponseReceived(data: FixturesResponse) {
        if(data.results==0){
            binding.nogame2.visibility = View.VISIBLE
        }
        else{
            binding.nogame2.visibility = View.INVISIBLE
            for (i in data.response) {
                val homeimg = i.teams.home.logo
                val homescore = i.goals.home
                val hometeam = i.teams.home.name
                val awayimg = i.teams.away.logo
                val awayscore = i.goals.away
                val awayteam = i.teams.away.name
                val startime = i.fixture.date
                val status = i.fixture.status.short
                var check: String
                val regex = Regex("""(\d{2}-\d{2})T(\d{2}:\d{2})""")
                val matchResult = regex.find(startime)
                val monthDay = matchResult?.groupValues!![1]
                val time = matchResult.groupValues[2]

                if(status == "TBD" || status == "NS")  check="$monthDay($time)"
                else if(status == "1H") check="전반"
                else if(status == "HT") check="전반 종료"
                else if(status == "2H") check="후반"
                else if(status == "ET") check="추가시간"
                else if(status =="BT") check="연장"
                else if(status=="P") check ="승부차기"
                else if(status == "SUSP" || status == "INT") check="경기 중단"
                else if(status == "FT" || status == "AET" || status=="PEN") check="경기 종료"
                else check="취소"
                Nadapter.addItem(
                    gameItem(homeimg,homescore,hometeam,awayimg,awayscore,awayteam,check)
                )
            }

        }

    }

    override fun onFixturesResponseError() {

    }


}