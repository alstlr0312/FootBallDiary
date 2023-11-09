package soccer.diary.footballapp.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.LeagueItemBinding
import soccer.diary.footballapp.features.LeagueDiary.LeagueFragment
import soccer.diary.footballapp.model.Leagues

class MainLeagueAdapter : RecyclerView.Adapter<MainLeagueAdapter.ViewHolder>() {

    var listData = mutableListOf<Leagues>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LeagueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val leagues = listData[position]
        holder.setMemo(leagues)
    }

    inner class ViewHolder(val binding: LeagueItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setMemo(leagues: Leagues) {
            binding.leagueImg.setImageDrawable(leagues.image)
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val leagues = listData[position]
                    val fragment = LeagueFragment()
                    val bundle = Bundle()
                    bundle.putInt("code", leagues.code)
                    fragment.arguments = bundle
                    val fragmentManager = (binding.root.context as AppCompatActivity).supportFragmentManager
                    fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit()
                }
            }
        }
    }
}
