package soccer.diary.footballapp.features.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.FragmentGetStatus1Binding
import soccer.diary.footballapp.databinding.FragmentLeagueBinding
import soccer.diary.footballapp.databinding.FragmentStatusBinding


class GetStatus1Fragment : Fragment() {
    private lateinit var binding: FragmentGetStatus1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStatus1Binding.inflate(inflater, container, false)
        return binding.root
    }

}