package soccer.diary.footballapp.features.status

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentGetStatus1Binding
import soccer.diary.footballapp.databinding.FragmentLeagueBinding
import soccer.diary.footballapp.databinding.FragmentStatusBinding
import soccer.diary.footballapp.features.home.NationalAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.model.StatusResponse
import soccer.diary.footballapp.model.gameItem
import java.text.SimpleDateFormat
import java.util.*


class GetStatus1Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus1Binding

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
            Log.d("tag", "noe")
            Log.d("tag", data.get)
            Log.d("dsfkl",data.results.toString())
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
                val id = i.fixture.id
                binding.textView7.text = hometeam
                Glide.with(requireContext()).load(Uri.parse(homeimg)).into(binding.imageView2)
            }

        }
    }

}
