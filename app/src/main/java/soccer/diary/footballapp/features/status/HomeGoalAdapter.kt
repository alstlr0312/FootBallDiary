package soccer.diary.footballapp.features.status

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.HomegoalItemBinding

class HomeGoalAdapter(private val context: Context) : RecyclerView.Adapter<HomeGoalAdapter.HomeGoalViewHolder>() {
    private val goalList: MutableList<String> = mutableListOf()

    fun addGoal(playerName: String) {
        goalList.add(playerName)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeGoalViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = HomegoalItemBinding.inflate(inflater, parent, false)
        return HomeGoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeGoalViewHolder, position: Int) {
        holder.bind(goalList[position])
    }

    override fun getItemCount(): Int {
        return goalList.size
    }

    inner class HomeGoalViewHolder(private val binding: HomegoalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(playerName: String) {
            binding.homeName.text=playerName
        }
    }
}
