package soccer.diary.footballapp.features.Ranking

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import soccer.diary.footballapp.databinding.RankItemBinding
import soccer.diary.footballapp.model.RankStanding


class RankAdapter(private val context: Context) : RecyclerView.Adapter<RankAdapter.ViewHolder>() {
    var itemList = mutableListOf<RankStanding>()
    private var listener : OnItemClickListener? = null
    inner class ViewHolder(private val binding: RankItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: RankStanding) {
            binding.rankingTxt.text = item.rank.toString()
            Glide.with(itemView).load(Uri.parse(item.team.logo)).into(binding.rankimg)
            binding.rankteamname.text = item.team.name
            binding.rankgame.text = item.all.played.toString()
            binding.rankwin.text = item.all.win.toString()
            binding.rankdraw.text = item.all.draw.toString()
            binding.ranklose.text = item.all.lose.toString()
            binding.textView13.text = item.points.toString()
            Log.d("rank",item.rank.toString())
            Log.d("rank",item.team.name)
            Log.d("rank", item.all.played.toString())
            Log.d("rank",item.all.win.toString())
            Log.d("rank",item.all.draw.toString())
            Log.d("rank",item.points.toString())

        }
        override fun onClick(v: View?) {
        }
    }

    interface OnItemClickListener{
        fun onItemClick(v: View, data: RankStanding, pos: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RankItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item: RankStanding){
        itemList.add(item)
        notifyItemChanged(itemCount-1)
    }

    fun removeAllItem(){
        itemList = mutableListOf()
        notifyDataSetChanged()
    }


}
