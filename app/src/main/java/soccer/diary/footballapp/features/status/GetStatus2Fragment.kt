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
import soccer.diary.footballapp.databinding.FragmentGetStatus2Binding
import soccer.diary.footballapp.model.StatusResponse
import soccer.diary.footballapp.model.lineupitem


class GetStatus2Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus2Binding
    private lateinit var adapter: LineupAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGetStatus2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            recyclerView = binding.startRv
            adapter = LineupAdapter(requireContext())
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            val data = it.getSerializable("data") as StatusResponse
            val lineup = data.response[0].lineups[0]
            val formation = lineup.formation
            val coach = lineup.coach.name
            Log.d("chflkd",formation)
            Log.d("chflkd2",coach)
            binding.formation.text=formation
            binding.coachName.text=coach
            val flag = data.response[0].teams.home.logo
            Glide.with(requireContext()).load(Uri.parse(flag)).into(binding.homeFlag)

            for(i in lineup.startXI){
                val num = i.player.number
                val name = i.player.name
                val postion = i.player.pos
                adapter.addItem(
                    lineupitem(num,name,postion)
                )
            }

        }
    }

}
