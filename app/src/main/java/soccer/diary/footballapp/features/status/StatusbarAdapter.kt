package soccer.diary.footballapp.features.status

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.StatusItemBinding
import soccer.diary.footballapp.model.statusbaritem


class StatusbarAdapter(private val context: Context) : RecyclerView.Adapter<StatusbarAdapter.ViewHolder>() {
    var itemList = mutableListOf<statusbaritem>()
    private var listener : OnItemClickListener? = null
    inner class ViewHolder(private val binding: StatusItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: statusbaritem) {
            Log.d("name",item.statusname)
            if (item.homescore is Double && item.awayscore is Double ) {
                val home = item.homescore.toInt()
                val away = item.awayscore.toInt()
                val all = home+away
                binding.homeBar.max = all
                binding.homeBar.setProgress(home)
                binding.awayBar.max = all
                binding.awayBar.setProgress(away)
                binding.sname.text=item.statusname
                binding.home.text=home.toString()
                binding.away.text=away.toString()
            }else if(item.homescore is String && item.awayscore is String ){
                val homeString = item.homescore.toString()
                val awayString = item.awayscore.toString()
                val homeScoreWithoutPercent = homeString.replace("%", "")
                val awayScoreWithoutPercent = awayString.replace("%", "")
                val home = homeScoreWithoutPercent.toIntOrNull() ?: 0
                val away = awayScoreWithoutPercent.toIntOrNull() ?: 0
                val all = home + away
                binding.homeBar.max = all
                binding.homeBar.setProgress(home)
                binding.awayBar.max = all
                binding.awayBar.setProgress(away)
                binding.sname.text=item.statusname
                binding.home.text = homeString
                binding.away.text = awayString
            }else{
                val home = item.homescore?.let { if (it is Double) it.toInt() else it.toString().replace("%", "").toIntOrNull() ?: 0 } ?: 0
                val away = item.awayscore?.let { if (it is Double) it.toInt() else it.toString().replace("%", "").toIntOrNull() ?: 0 } ?: 0
                val all = home + away
                binding.homeBar.max = all
                binding.homeBar.setProgress(home)
                binding.awayBar.max = all
                binding.awayBar.setProgress(away)
                binding.sname.text = item.statusname
                binding.home.text = item.homescore?.toString() ?: "0"
                binding.away.text = item.awayscore?.toString() ?: "0"
            }

        }
        override fun onClick(v: View?) {
            if (position != RecyclerView.NO_POSITION) {

            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(v: View, data: statusbaritem, pos: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(StatusItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item: statusbaritem){
        itemList.add(item)
        notifyItemChanged(itemCount-1)
    }

    fun removeAllItem(){
        itemList = mutableListOf()
        notifyDataSetChanged()
    }


}
