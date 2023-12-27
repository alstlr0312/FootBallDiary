package soccer.diary.footballapp.features.status

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
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
                val num = it.games.number.toString()
                val playtime = it.games.minutes.toString()
                val rateing = it.games.rating?.toFloat() ?: 0.0f
                val goal = it.goals.total?.toString()?: "0"
                val assist = it.goals.assists?.toString() ?: "0"
                val totalshot = it.shots.total.toString()
                val onshot = it.shots.on.toString()
                val pass = it.passes.total.toString()
                val kpass = it.passes.key.toString()
                val passa = it.passes.accuracy
                val save = it.goals.saves.toString()
                val cap = it.games.captain
                val blocktakel = it.tackles.blocks.toString()
                val intercepttakel = it.tackles.interceptions.toString()
                val dribble = it.dribbles.attempts.toString()
                val sdribble = it.dribbles.success.toString()
                val offside = it.offsides.toString()
                val ycard = it.cards.yellow.toString()
                val rcard = it.cards.red.toString()
                val dofoul = it.fouls.committed.toString()
                if(cap==true){
                    binding.captian.visibility = View.VISIBLE
                }else binding.captian.visibility = View.INVISIBLE
                binding.playerp.text= num
                binding.playtime.text=playtime+"분"
                when {
                    rateing <= 5.0 -> binding.rateing.setTextColor(Color.RED)
                    rateing in 5.1..7.9 -> binding.rateing.setTextColor(Color.parseColor("#FFA500")) // 주황색
                    else -> binding.rateing.setTextColor(Color.GREEN)
                }
                binding.rateing.text = rateing.toString()
                binding.goal.text=goal
                binding.assist.text=assist
                binding.totalshot.text=totalshot+"/"+onshot
                binding.pass.text=pass+"/"+kpass
                binding.passacc.text=passa+"%"
                binding.save.text=save
                binding.takles.text=blocktakel+"/"+intercepttakel
                binding.dribble.text=dribble+"/"+sdribble
                binding.offside.text=offside
                binding.foul.text=dofoul
                binding.card.text=ycard+"/"+rcard
            }
            binding.playern.text = name
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
