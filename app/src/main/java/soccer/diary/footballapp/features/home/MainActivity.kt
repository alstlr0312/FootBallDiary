package soccer.diary.footballapp.features.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.StateSet
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import com.unity.mynativeapp.network.RetrofitClient
import okhttp3.Call
import okhttp3.Response
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.ActivityMainBinding
import soccer.diary.footballapp.model.FixturesResponse
import soccer.diary.footballapp.model.Leagues
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var LrecyclerView: RecyclerView
    private lateinit var Ladapter: MainLeagueAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LrecyclerView = binding.leagueRv
        Ladapter = MainLeagueAdapter()

        LrecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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

        Ladapter.listData = leaguesList
        LrecyclerView.adapter = Ladapter

        RetrofitClient.getfixtures("33-34",39,2023,object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("error","error")
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseStr = response.body?.string()
                    Log.d(StateSet.TAG, "findPlacesByText response: $responseStr")
                    RetrofitClient.showResults(responseStr!!)
                } else {
                    // Request not successful
                }
            }
        })

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }



    }
}