package soccer.diary.footballapp.features.Ranking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import soccer.diary.footballapp.databinding.FragmentRankingBinding

class RankingFragment : Fragment() {
    private lateinit var binding: FragmentRankingBinding
    var code:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("code", 0)
        }
    }

}