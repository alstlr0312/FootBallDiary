package soccer.diary.footballapp.features.status

import android.app.AlertDialog
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import soccer.diary.footballapp.databinding.FragmentPlayerDialogBinding
import soccer.diary.footballapp.databinding.FragmentRankingBinding
import soccer.diary.footballapp.features.Ranking.RankAdapter
import soccer.diary.footballapp.features.home.VerticalItemDecorator
import soccer.diary.footballapp.model.Statistic
import soccer.diary.footballapp.model.lineupitem
import soccer.diary.footballapp.model.onBackPressedListener

class PlayerDialog : DialogFragment(), onBackPressedListener{
    private lateinit var binding: FragmentPlayerDialogBinding
    private lateinit var lineupAdapter: LineupAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentPlayerDialogBinding.inflate(layoutInflater)
        val view = binding.root
        arguments?.let {
            val face = it.getString("face", "김민식")
            val name = it.getString("name", "김민식")
            val statistics: ArrayList<Statistic>? = arguments?.getParcelableArrayList<Statistic>("statistics")
            statistics?.forEach { it ->
                binding.playerp.text= it.games.number.toString()
            }
            Glide.with(view.context).load(Uri.parse(face)).into(binding.playerface)

        }


        val builder = AlertDialog.Builder(requireContext())
        builder.setView(view)
        return builder.create()
    }

    override fun onBackPressed() {
        dismiss()
    }
}
