package soccer.diary.footballapp.features.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
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
        val kligue = resources.getDrawable(R.drawable.k_logo, null)
        val leaguesList = mutableListOf<Leagues>()
        leaguesList.add(Leagues("챔피언스리그", cl))
        leaguesList.add(Leagues("프리미어리그", pl))
        leaguesList.add(Leagues("분데리스가", bun))
        leaguesList.add(Leagues("리그 1", ligue1))
        leaguesList.add(Leagues("k리그", kligue))

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        val calendar = Calendar.getInstance()
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_MONTH, -1)
        val previousDate = calendar.time
        val previousDateString = dateFormat.format(previousDate)
        val dateString = dateFormat.format(currentDate)
        NrecyclerView = binding.nationalRv
        Nadapter = NationalAdapter(this)
        NrecyclerView.layoutManager = LinearLayoutManager(this)
        NrecyclerView.adapter = Nadapter
        Log.d("date","33-34")
        viewModel.fixtures(39,2023,"2023-11-04","2023-11-06",this)
    }
    override fun onFixturesResponseReceived(data: FixturesResponse) {
        for (i in data.response) {
            val homeimg = i.teams.home.logo
            val homescore = i.goals.home
            val hometeam = i.teams.home.name
            val awayimg = i.teams.away.logo
            val awayscore = i.goals.away
            val awayteam = i.teams.away.name
            val startime = i.fixture.date
            Nadapter.addItem(
                gameItem(homeimg,homescore,hometeam,awayimg,awayscore,awayteam,startime)
            )
        }

    }

    override fun onFixturesResponseError() {

    }
}