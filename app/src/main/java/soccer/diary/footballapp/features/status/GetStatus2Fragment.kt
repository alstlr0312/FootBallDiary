package soccer.diary.footballapp.features.status

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import soccer.diary.footballapp.databinding.FragmentGetStatus1Binding
import soccer.diary.footballapp.databinding.FragmentGetStatus2Binding
import soccer.diary.footballapp.model.StatusResponse


class GetStatus2Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus2Binding

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
            val data = it.getSerializable("data") as StatusResponse
            Log.d("tag", "noe")
            Log.d("tag", data.get)
            Log.d("dsfkl",data.results.toString())
            for (i in data.response[0].lineups) {
                val formation = i.formation
                val team = i.team.logo
                for(j in i.startXI){
                    j.player.name
                }
            }

        }
    }

}
