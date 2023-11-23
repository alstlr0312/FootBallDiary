package soccer.diary.footballapp.features.status

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.LineupItemBinding
import soccer.diary.footballapp.model.lineupitem


class LineupAdapter(private val context: Context) : RecyclerView.Adapter<LineupAdapter.ViewHolder>() {
    var itemList = mutableListOf<lineupitem>()
    private var listener : OnItemClickListener? = null
    inner class ViewHolder(private val binding: LineupItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: lineupitem) {
            val name = item.name
            val num = item.num
            val position = item.postion
            binding.playerNum.text=num.toString()
            binding.playerName.text=name
            binding.playerPosition.text=position
        }
        override fun onClick(v: View?) {
            if (position != RecyclerView.NO_POSITION) {

            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(v: View, data: lineupitem, pos: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LineupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(item: lineupitem){
        itemList.add(item)
        notifyItemChanged(itemCount-1)
    }

    fun removeAllItem(){
        itemList = mutableListOf()
        notifyDataSetChanged()
    }


}
