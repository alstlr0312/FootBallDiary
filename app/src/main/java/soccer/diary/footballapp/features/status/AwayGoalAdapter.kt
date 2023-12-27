package soccer.diary.footballapp.features.status

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.AwaygoalItemBinding
import soccer.diary.footballapp.databinding.HomegoalItemBinding

class AwayGoalAdapter(private val context: Context) : RecyclerView.Adapter<AwayGoalAdapter.AwayGoalViewHolder>() {
    private val goalList: MutableList<String> = mutableListOf()

    fun addGoal(playerName: String) {
        goalList.add(playerName)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwayGoalViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = AwaygoalItemBinding.inflate(inflater, parent, false)
        return AwayGoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AwayGoalViewHolder, position: Int) {
        holder.bind(goalList[position])
    }

    override fun getItemCount(): Int {
        return goalList.size
    }

    inner class AwayGoalViewHolder(private val binding: AwaygoalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(playerName: String) {
            binding.awayName.text=playerName
        }
    }
}
