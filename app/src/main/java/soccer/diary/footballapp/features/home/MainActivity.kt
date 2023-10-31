package soccer.diary.footballapp.features.home

import android.annotation.SuppressLint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.ActivityMainBinding
import soccer.diary.footballapp.model.Leagues
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainLeagueAdapter
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.leagueRv
        adapter = MainLeagueAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(HorizontalItemDecorator(20))
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



        adapter.listData = leaguesList
        recyclerView.adapter = adapter
    }



}