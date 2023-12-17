package soccer.diary.footballapp.features.status

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
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
                val flag = data.response[0].teams.home.logo
                Glide.with(requireContext()).load(Uri.parse(flag)).into(binding.teamlogo)
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
                }else if (formation == "3-5-2") {
                    binding.f352.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:1" }
                    val cb4 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:5" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:4" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:3" }
                    val cm3 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "3:1" }
                    val f2 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:2" }
                    val f3 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:1" }
                    binding.gk352t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb3521t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb3522t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb3523t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.dm352t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.cm3521t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.cm3522t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.cm3523t.text = formatPlayerName(cm3?.player?.name) ?: "M"
                    binding.cm3524t.text = formatPlayerName(f1?.player?.name) ?: "F"
                    binding.f3521t.text = formatPlayerName(f2?.player?.name) ?: "F"
                    binding.f3522t.text = formatPlayerName(f3?.player?.name) ?: "F"

                    binding.gk352.text = (gp?.player?.number ?: 0).toString()
                    binding.cb3521.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb3522.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb3523.text = (cb3?.player?.number ?: 0).toString()
                    binding.dm352.text = (cb4?.player?.number ?: 0).toString()
                    binding.cm3521.text = (cm1?.player?.number ?: 0).toString()
                    binding.cm3522.text = (cm2?.player?.number ?: 0).toString()
                    binding.cm3523.text = (cm3?.player?.number ?: 0).toString()
                    binding.cm3524.text = (f1?.player?.number ?: 0).toString()
                    binding.f3521.text = (f2?.player?.number ?: 0).toString()
                    binding.f3522.text = (f3?.player?.number ?: 0).toString()
                }else if (formation == "4-2-3-1") {
                    binding.f4231.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:4" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb4 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "2:1" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:1" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val m1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "4:3" }
                    val m2 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:2" }
                    val m3 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:1" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "5:1" }
                    binding.gk4231t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb42311t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb42312t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb42313t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.cb42314t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.cm42311t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.cm42312t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.m42311t.text = formatPlayerName(m1?.player?.name) ?: "M"
                    binding.m42312t.text = formatPlayerName(m2?.player?.name) ?: "F"
                    binding.m42313t.text = formatPlayerName(m1?.player?.name) ?: "F"
                    binding.f42311t.text = formatPlayerName(f1?.player?.name) ?: "F"

                    binding.gk4231.text = (gp?.player?.number ?: 0).toString()
                    binding.cb42311.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb42312.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb42313.text = (cb3?.player?.number ?: 0).toString()
                    binding.cb42314.text = (cb4?.player?.number ?: 0).toString()
                    binding.cm42311.text = (cm1?.player?.number ?: 0).toString()
                    binding.cm42312.text = (cm2?.player?.number ?: 0).toString()
                    binding.m42311.text = (m1?.player?.number ?: 0).toString()
                    binding.m42312.text = (m2?.player?.number ?: 0).toString()
                    binding.m42313.text = (m3?.player?.number ?: 0).toString()
                    binding.f42311.text = (f1?.player?.number ?: 0).toString()
                }else if (formation == "4-5-1") {
                    binding.f451.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:4" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb4 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:1" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:5" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:4" }
                    val cm3 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:3" }
                    val cm4 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val cm5 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:1" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:1" }
                    binding.gk451t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb4511t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb4512t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb4513t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.cb4514t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.cm4511t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.m4511t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.m4512t.text = formatPlayerName(cm3?.player?.name) ?: "M"
                    binding.m4513t.text = formatPlayerName(cm4?.player?.name) ?: "F"
                    binding.m4514t.text = formatPlayerName(cm5?.player?.name) ?: "F"
                    binding.f4511t.text = formatPlayerName(f1?.player?.name) ?: "F"

                    binding.gk451.text = (gp?.player?.number ?: 0).toString()
                    binding.cb4511.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb4512.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb4513.text = (cb3?.player?.number ?: 0).toString()
                    binding.cb4514.text = (cb4?.player?.number ?: 0).toString()
                    binding.cm4511.text = (cm1?.player?.number ?: 0).toString()
                    binding.m4511.text = (cm2?.player?.number ?: 0).toString()
                    binding.m4512.text = (cm3?.player?.number ?: 0).toString()
                    binding.m4513.text = (cm4?.player?.number ?: 0).toString()
                    binding.m4514.text = (cm5?.player?.number ?: 0).toString()
                    binding.f4511.text = (f1?.player?.number ?: 0).toString()
                }
                else if (formation == "4-4-1-1") {
                    binding.f4411.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:4" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb4 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:1" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:4" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:3" }
                    val cm3 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val cm4 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:1" }
                    val cm5 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "4:1" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "5:1" }
                    binding.gk4411t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb44111t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb44112t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb44113t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.cb44114t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.cm44111t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.m44111t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.m44112t.text = formatPlayerName(cm3?.player?.name) ?: "M"
                    binding.m44113t.text = formatPlayerName(cm4?.player?.name) ?: "M"
                    binding.m44114t.text = formatPlayerName(cm5?.player?.name) ?: "M"
                    binding.f44111t.text = formatPlayerName(f1?.player?.name) ?: "ST"

                    binding.gk4411.text = (gp?.player?.number ?: 0).toString()
                    binding.cb44111.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb44112.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb44113.text = (cb3?.player?.number ?: 0).toString()
                    binding.cb44114.text = (cb4?.player?.number ?: 0).toString()
                    binding.cm44111.text = (cm1?.player?.number ?: 0).toString()
                    binding.m44111.text = (cm2?.player?.number ?: 0).toString()
                    binding.m44112.text = (cm3?.player?.number ?: 0).toString()
                    binding.m44113.text = (cm4?.player?.number ?: 0).toString()
                    binding.m44114.text = (cm5?.player?.number ?: 0).toString()
                    binding.f44111.text = (f1?.player?.number ?: 0).toString()
                }
                else if (formation == "3-4-3") {
                    binding.f343.visibility=View.VISIBLE
                    val gp = lineup.startXI.find { it.player.pos == "G" && it.player.grid == "1:1" }
                    val cb1 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:3" }
                    val cb2 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:2" }
                    val cb3 = lineup.startXI.find { it.player.pos == "D" && it.player.grid == "2:1" }
                    val cb4 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:4" }
                    val cm1 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:3" }
                    val cm2 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:2" }
                    val cm3 = lineup.startXI.find { it.player.pos == "M" && it.player.grid == "3:1" }
                    val cm4 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:3" }
                    val cm5 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:2" }
                    val f1 = lineup.startXI.find { it.player.pos == "F" && it.player.grid == "4:1" }
                    binding.gk343t.text = formatPlayerName(gp?.player?.name)?: "G"
                    binding.cb3431t.text = formatPlayerName(cb1?.player?.name)?: "D"
                    binding.cb3432t.text = formatPlayerName(cb2?.player?.name)?: "D"
                    binding.cb3433t.text = formatPlayerName(cb3?.player?.name)?: "D"
                    binding.m3431t.text = formatPlayerName(cb4?.player?.name)?: "D"
                    binding.m3432t.text = formatPlayerName(cm1?.player?.name)?: "M"
                    binding.m3433t.text = formatPlayerName(cm2?.player?.name) ?: "M"
                    binding.m3434t.text = formatPlayerName(cm3?.player?.name) ?: "M"
                    binding.f3431t.text = formatPlayerName(cm4?.player?.name) ?: "M"
                    binding.f3432t.text = formatPlayerName(cm5?.player?.name) ?: "M"
                    binding.f3433t.text = formatPlayerName(f1?.player?.name) ?: "ST"

                    binding.gk343.text = (gp?.player?.number ?: 0).toString()
                    binding.cb3431.text = (cb1?.player?.number ?: 0).toString()
                    binding.cb3432.text = (cb2?.player?.number ?: 0).toString()
                    binding.cb3433.text = (cb3?.player?.number ?: 0).toString()
                    binding.m3431.text = (cb4?.player?.number ?: 0).toString()
                    binding.m3432.text = (cm1?.player?.number ?: 0).toString()
                    binding.m3433.text = (cm2?.player?.number ?: 0).toString()
                    binding.m3434.text = (cm3?.player?.number ?: 0).toString()
                    binding.f3431.text = (cm4?.player?.number ?: 0).toString()
                    binding.f3432.text = (cm5?.player?.number ?: 0).toString()
                    binding.f3433.text = (f1?.player?.number ?: 0).toString()
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
