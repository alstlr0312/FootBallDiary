package soccer.diary.footballapp.features.home

import android.graphics.Rect
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.LeagueItemBinding
import soccer.diary.footballapp.model.Leagues

class MainLeagueAdapter : RecyclerView.Adapter<MainLeagueAdapter.ViewHolder>()  {

    var listData = mutableListOf<Leagues>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LeagueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val memo = listData.get(position)
        holder.setMemo(memo)
    }


    class ViewHolder(val binding: LeagueItemBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                //Toast.makeText(binding.root.context, "item = ${binding.textTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }

        fun setMemo(leagues: Leagues) {
            binding.leagueImg.setImageDrawable(leagues.image)
        }

    }
}

