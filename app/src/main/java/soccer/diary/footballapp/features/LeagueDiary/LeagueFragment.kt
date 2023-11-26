package soccer.diary.footballapp.features.LeagueDiary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentLeagueBinding
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.model.FixturesResponse
import soccer.diary.footballapp.model.ResponseObserver
import soccer.diary.footballapp.model.gameItem
import soccer.diary.footballapp.model.onBackPressedListener
import java.text.SimpleDateFormat
import java.util.*

class LeagueFragment : Fragment(), onBackPressedListener {
    private lateinit var Nadapter: NationalAdapter
    private lateinit var NrecyclerView: RecyclerView
    private lateinit var binding: FragmentLeagueBinding
    private val viewModel by viewModels<LeagueViewModel>()
    var code:Int = 0
    var backPressedTime : Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("code", 0)
        }
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val previousDate = calendar.time
        val previousDateString = dateFormat.format(previousDate)
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val nextDate = calendar.time
        val nextDateString = dateFormat.format(nextDate)
        setbackground(code)
        NrecyclerView = binding.LeagueRv
        Nadapter = NationalAdapter(requireContext())
        NrecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        NrecyclerView.adapter = Nadapter
        NrecyclerView.addItemDecoration(VerticalItemDecorator(20))
        viewModel.getFixtures(code, year, previousDateString, nextDateString)
        subscribeUI()
    }
    fun setbackground(code: Int) {
        val background = binding.leagueBack
        val logo = binding.leagueLogo
        when (code) {
            2 -> {
                background.setImageResource(R.drawable.cham_background)
                logo.setImageResource(R.drawable.cham_3)
            }
            39 -> {
                background.setImageResource(R.drawable.primeir_background)
                logo.setImageResource(R.drawable.primer_light)
            }
            78 -> {
                background.setImageResource(R.drawable.bun_background)
                logo.setImageResource(R.drawable.bun_logo2)
            }
            61 -> {
                background.setImageResource(R.drawable.legue_1_background)
                logo.setImageResource(R.drawable.ligue1_logo)
            }
            140 -> {
                background.setImageResource(R.drawable.lalgue_background)
                logo.setImageResource(R.drawable.la_2)
            }
            292 -> {
                background.setImageResource(R.drawable.kbackground)
                logo.setImageResource(R.drawable.k_logo)
            }
            else -> {
                background.setImageResource(R.drawable.primeir_background)
                logo.setImageResource(R.drawable.pl_logo2)
            }
        }
    }


    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }

    private fun subscribeUI() {
        viewModel.fixturesResponse.removeObservers(viewLifecycleOwner)
        viewModel.fixturesResponse.observe(viewLifecycleOwner) { data ->
            if (data.results == 0) {
                binding.nogame2.visibility = View.VISIBLE
            } else {
                binding.nogame2.visibility = View.INVISIBLE
                val distinctResponse = data.response.distinctBy { it.fixture.date }
                val sortedResponse = distinctResponse.sortedWith(compareBy { it.fixture.date })
                Log.d("id", sortedResponse.size.toString())
                for (i in sortedResponse) {
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
                    val id = i.fixture.id
                    val dateFormat = SimpleDateFormat("MM-dd HH:mm", Locale.getDefault())
                    dateFormat.timeZone = TimeZone.getTimeZone("Europe/London")
                    val startDateTime = dateFormat.parse("$monthDay $time")
                    dateFormat.timeZone = TimeZone.getTimeZone("Asia/Seoul")
                    val calendar = Calendar.getInstance()
                    calendar.time = startDateTime
                    calendar.add(Calendar.HOUR_OF_DAY, 1)//영국 서머 타임때문에 +1시간 해야함
                    val koreaTime = dateFormat.format(calendar.time)
                    if (status == "TBD" || status == "NS") check = "$koreaTime"
                    else if (status == "1H") check = "전반"
                    else if (status == "HT") check = "전반 종료"
                    else if (status == "2H") check = "후반"
                    else if (status == "ET") check = "추가시간"
                    else if (status == "BT") check = "연장"
                    else if (status == "P") check = "승부차기"
                    else if (status == "SUSP" || status == "INT") check = "경기 중단"
                    else if (status == "FT" || status == "AET" || status == "PEN") check = "경기 종료"
                    else check = "취소"
                    Nadapter.addItem(gameItem(homeimg, homescore, hometeam, awayimg, awayscore, awayteam, check, id))
                    Log.d("id", id.toString())
                }

            }
        }
    }


}