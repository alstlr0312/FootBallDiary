package soccer.diary.footballapp.features.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import soccer.diary.footballapp.MyApplication
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.ActivityMainBinding
import soccer.diary.footballapp.model.FixturesResponse
import soccer.diary.footballapp.model.Leagues
import soccer.diary.footballapp.model.gameItem
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), ResponseObserver {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var LrecyclerView: RecyclerView
    private lateinit var Ladapter: MainLeagueAdapter
    private lateinit var Nadapter: NationalAdapter
    private lateinit var NrecyclerView: RecyclerView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LrecyclerView = binding.leagueRv
        Ladapter = MainLeagueAdapter()

        LrecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        LrecyclerView.setHasFixedSize(true)
        LrecyclerView.addItemDecoration(HorizontalItemDecorator(20))

        val cl = resources.getDrawable(R.drawable.cl_logo, null)
        val bun = resources.getDrawable(R.drawable.bun_logo, null)
        val pl = resources.getDrawable(R.drawable.pl_logo, null)
        val ligue1 = resources.getDrawable(R.drawable.ligue1_logo, null)
        val Lalliga = resources.getDrawable(R.drawable.laliga_logo, null)
        val kligue = resources.getDrawable(R.drawable.kleague_logo, null)
        val leaguesList = mutableListOf<Leagues>()
        leaguesList.add(Leagues(R.string.Champions.toString(), cl))
        leaguesList.add(Leagues(R.string.Primier.toString(), pl))
        leaguesList.add(Leagues(R.string.Bunleague.toString(), bun))
        leaguesList.add(Leagues(R.string.Ligue_1.toString(), ligue1))
        leaguesList.add(Leagues(R.string.Laliga.toString(), Lalliga))
        leaguesList.add(Leagues(R.string.K_league.toString(), kligue))
        Ladapter.listData = leaguesList
        LrecyclerView.adapter = Ladapter

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val previousDate = calendar.time
        val previousDateString = dateFormat.format(previousDate)
        val dateString = dateFormat.format(currentDate)
        NrecyclerView = binding.nationalRv
        Nadapter = NationalAdapter(this)
        NrecyclerView.layoutManager = LinearLayoutManager(this)
        NrecyclerView.adapter = Nadapter
        NrecyclerView.addItemDecoration(VerticalItemDecorator(20))

        val frendliesvalue = MyApplication.leaguePartHashMap[getString(R.string.Friendlies)]!!
        viewModel.fixtures(frendliesvalue,year,previousDateString,dateString,this)
    }
    override fun onFixturesResponseReceived(data: FixturesResponse) {
        if(data.results==0){
            binding.nogame.visibility = View.VISIBLE
        }
        else{
            binding.nogame.visibility = View.INVISIBLE
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