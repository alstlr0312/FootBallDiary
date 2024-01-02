package soccer.diary.footballapp.features.status

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentStatusBinding
import soccer.diary.footballapp.model.*

class StatusFragment : Fragment(), onBackPressedListener {
    private lateinit var binding: FragmentStatusBinding
    private val viewModel by viewModels<StatusViewModel>()
    var code: Int = 0
    var backPressedTime: Long = 0
    private lateinit var hadapter: HomeGoalAdapter
    private lateinit var hrecyclerView: RecyclerView
    private lateinit var aadapter: AwayGoalAdapter
    private lateinit var arecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        loadingProgressBar = binding.root.findViewById(R.id.LoadingBar)
        loadingProgressBar.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("code", 0)
            Log.d("code",code.toString())
            viewModel.status(code)
            subscribeUI()
        }
    }


    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }


    private fun subscribeUI() {
        viewModel.statusResponse.observe(viewLifecycleOwner) { data ->
            loadingProgressBar.visibility = View.INVISIBLE
            val homeimg = data.response[0].teams.home.logo
            val homescore = data.response[0].goals.home
            binding.shomeScore.text = homescore.toString()
            Glide.with(requireContext()).load(Uri.parse(homeimg)).into(binding.shomeImg)
            val awayimg = data.response[0].teams.away.logo
            val awayscore = data.response[0].goals.away
            binding.sawayScore.text = awayscore.toString()
            Glide.with(requireContext()).load(Uri.parse(awayimg)).into(binding.sawayImg)
            val status = data.response[0].fixture.status.short
            var check:String
            val startime = data.response[0].fixture.date
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
            binding.gameState.text=check
            var league = data.response[0].league.name
            if(league=="Friendlies"){
                league="친선전"
            }
            val homename = data.response[0].teams.home.name
            val awayname= data.response[0].teams.away.name
            val eventData = data.response[0].events
            hrecyclerView = binding.homerv
            hadapter = HomeGoalAdapter(requireContext())
            hrecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            hrecyclerView.adapter = hadapter

            arecyclerView = binding.awayrv
            aadapter = AwayGoalAdapter(requireContext())
            arecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            arecyclerView.adapter = aadapter

            val goalEventsByTeam = eventData.filter { it.type == "Goal" }.groupBy { it.team.name }

            for ((teamName, events) in goalEventsByTeam) {
                println("Team: $teamName")
                for (event in events) {
                    val playerName = event.player.name
                    if(teamName==homename){
                        hadapter.addGoal(playerName)
                    }else if(teamName==awayname){
                        aadapter.addGoal(playerName)
                    }
                }
            }
            binding.leaguename.text=league
            val viewPager2Adapter = ViewPager2Adapter(requireActivity())
            val bundle = Bundle()
            bundle.putSerializable("data", data)
            val getStatus1Fragment = GetStatus1Fragment()
            val getStatus2Fragment = GetStatus2Fragment()
            val getStatus4Fragment = GetStatus4Fragment()
            val getStatus3Fragment = GetStatus3Fragment()
            val getStatus5Fragment = GetStatus5Fragment()
            getStatus1Fragment.arguments = bundle
            getStatus2Fragment.arguments = bundle
            getStatus4Fragment.arguments = bundle
            getStatus3Fragment.arguments = bundle
            getStatus5Fragment.arguments = bundle
            viewPager2Adapter.addFragment(getStatus1Fragment)
            viewPager2Adapter.addFragment(getStatus2Fragment)
            viewPager2Adapter.addFragment(getStatus4Fragment)
            viewPager2Adapter.addFragment(getStatus3Fragment)
            viewPager2Adapter.addFragment(getStatus5Fragment)
            viewPager2Adapter.notifyDataSetChanged()
            binding.vpViewpagerMain.adapter = viewPager2Adapter

        }
    }


}