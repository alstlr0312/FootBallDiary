package soccer.diary.footballapp.features.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import soccer.diary.footballapp.databinding.FragmentStatusBinding
import soccer.diary.footballapp.features.LeagueDiary.LeagueViewModel
import soccer.diary.footballapp.model.*

class StatusFragment : Fragment(), StatusResponseObserver, onBackPressedListener {
    private lateinit var binding: FragmentStatusBinding
    private val viewModel by viewModels<LeagueViewModel>()
    var code: Int = 0
    var backPressedTime: Long = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            code = it.getInt("Id", 0)
        }

        initViewPager()
    }

    private fun initViewPager() {
        // ViewPager2 Adapter setting
        val viewPager2Adapter = ViewPager2Adapter(requireActivity())
        viewPager2Adapter.addFragment(GetStatus1Fragment())
        viewPager2Adapter.addFragment(GetStatus2Fragment())
        viewPager2Adapter.addFragment(GetStatus3Fragment())

        // Adapter connection
        binding.vpViewpagerMain.apply {
            adapter = viewPager2Adapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    // Handle page selected event if needed
                }
            })
        }

    }


    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }

    override fun onLineupResponseReceived(lineupsResponse: LineupsResponse) {
        TODO("Not yet implemented")
    }

    override fun onStatusResponseReceived(statusResponse: StatusResponse) {
        TODO("Not yet implemented")
    }

}