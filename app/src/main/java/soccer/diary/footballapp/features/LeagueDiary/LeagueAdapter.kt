package soccer.diary.footballapp.features.LeagueDiary

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.League2ItemBinding
import soccer.diary.footballapp.features.status.StatusFragment
import soccer.diary.footballapp.model.gameItem


class LeagueAdapter(private val context: Context) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    var itemList = mutableListOf<gameItem>()
    private var listener : OnItemClickListener? = null
    inner class ViewHolder(private val binding:League2ItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: gameItem) {
            Glide.with(itemView).load(Uri.parse(item.homeimg)).into(binding.homeImg)
            binding.homeScore.text = item.homescore.toString()
            binding.homeTeamName.text = item.hometeam
            Glide.with(itemView).load(Uri.parse(item.awayimg)).into(binding.awayImg)
            binding.awayScore.text = item.awayscore.toString()
            binding.awayTeamName.text = item.awayteam
            binding.gameStateTxt.text = item.startime

        }
        override fun onClick(v: View?) {
            val pos = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val leagues = itemList[position]
                val fragment = StatusFragment()
                val bundle = Bundle()
                bundle.putInt("code", leagues.id)
                fragment.arguments = bundle
                val fragmentManager = (binding.root.context as AppCompatActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(v: View, data: gameItem, pos: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(League2ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        //배경 변경

        val itemBackground = ContextCompat.getDrawable(holder.itemView.context, R.drawable.national_shadow_view)
        val itemBackground2 = ContextCompat.getDrawable(holder.itemView.context, R.drawable.national_shadow_view2)
        if (position % 2 == 0) {
            holder.itemView.background = itemBackground
        } else {
            holder.itemView.background = itemBackground2
        }

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item: gameItem){
        itemList.add(item)
        notifyItemChanged(itemCount-1)
    }

    fun removeAllItem(){
        itemList = mutableListOf()
        notifyDataSetChanged()
    }


}
