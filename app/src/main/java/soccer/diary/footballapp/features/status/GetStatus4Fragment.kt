package soccer.diary.footballapp.features.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import soccer.diary.footballapp.databinding.FragmentGetStatus4Binding
import soccer.diary.footballapp.model.StatusResponse


class GetStatus4Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGetStatus4Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val data = it.getSerializable("data") as StatusResponse

            if (data.response.isNotEmpty() && data.response[0].lineups.isNotEmpty()) {
                val lineup = data.response[0].lineups[0]
                val formation = lineup.formation
                if (formation == "4-3-3") {
                    binding.f433.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:4" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb4 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:1" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:3" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val cm3 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:1" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:3" }
                    val f2 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:2" }
                    val f3 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:1" }
                    binding.gk433t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb4331t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb4332t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb4333t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.cb4334t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.cm4331t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.cm4332t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.cm4333t.text = formatPlayerName(cm3?.player?.name) ?: "M"
                    binding.f4331t.text = formatPlayerName(f1?.player?.name) ?: "F"
                    binding.f4332t.text = formatPlayerName(f2?.player?.name) ?: "F"
                    binding.f4333t.text = formatPlayerName(f3?.player?.name) ?: "F"

                    binding.gk433.text = (gp?.player?.number ?: 0).toString()
                    binding.cb4331.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb4332.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb4333.text = (cb3?.player?.number ?: 0).toString()
                    binding.cb4334.text = (cb4?.player?.number ?: 0).toString()
                    binding.cm4331.text = (cm1?.player?.number ?: 0).toString()
                    binding.cm4332.text = (cm2?.player?.number ?: 0).toString()
                    binding.cm4333.text = (cm3?.player?.number ?: 0).toString()
                    binding.f4331.text = (f1?.player?.number ?: 0).toString()
                    binding.f4332.text = (f2?.player?.number ?: 0).toString()
                    binding.f4333.text = (f3?.player?.number ?: 0).toString()
                }
            }
        }
    }
    fun formatPlayerName(playerName: String?): String? {
        return if (playerName?.contains(" ") == true) {
            playerName.split(" ").let { "${it[0][0]}.${it[1]}" }
        } else {
            playerName
        }
    }

}
