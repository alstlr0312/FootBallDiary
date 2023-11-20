package soccer.diary.footballapp.features.status

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import soccer.diary.footballapp.databinding.FragmentGetStatus1Binding
import soccer.diary.footballapp.model.StatusResponse
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
            //1.유효슛 2.슛 3.막힌슛 4.전체슛 5.박스내에서슛 6.박스밖에서슛 7.파울 8.코너킥 9.오프사이드
            //10.점유율 11.열로카드 12.레드카드 13.키퍼세입 14.전체패스 15.정확한패스 16.패스정확도
            val statics: Array<Array<Any>> = Array(2) { Array(16) { 0 } }
            for (i in 0 .. 1) {
                for (j in 0..15) {
                    statics[i][j] = data.response[0].statistics[i].statistics[j].value
                }
            }
            val homevshot = statics[0][0]
            val awayvshot = statics[1][0]
            if (homevshot is Double && awayvshot is Double ) {
                val home = homevshot.toInt()
                val away = awayvshot.toInt()
                val all = home+away
                binding.sogBar.max = all
                binding.sogBar.setProgress(home)
            }
        }
    }

}
