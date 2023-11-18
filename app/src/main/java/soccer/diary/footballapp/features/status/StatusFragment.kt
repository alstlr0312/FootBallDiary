package soccer.diary.footballapp.features.status

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import soccer.diary.footballapp.databinding.FragmentStatusBinding
import soccer.diary.footballapp.model.*

class StatusFragment : Fragment(), StatusResponseObserver, onBackPressedListener {
    private lateinit var binding: FragmentStatusBinding
    private val viewModel by viewModels<StatusViewModel>()
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
            code = it.getInt("code", 0)
            viewModel.status(code, this)
        }

    }





    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
    }

    override fun onStatusResponseReceived(data: StatusResponse) {

        requireActivity().runOnUiThread {
            val viewPager2Adapter = ViewPager2Adapter(requireActivity())
            val bundle = Bundle()
            bundle.putSerializable("data", data)
            val getStatus1Fragment = GetStatus1Fragment()
            getStatus1Fragment.arguments = bundle
            viewPager2Adapter.addFragment(getStatus1Fragment)
            viewPager2Adapter.notifyDataSetChanged()
            binding.vpViewpagerMain.adapter = viewPager2Adapter
        }
    }
}