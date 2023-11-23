package soccer.diary.footballapp.features.status

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.databinding.SublineupItemBinding
import soccer.diary.footballapp.model.lineupitem


class SublineupAdapter(private val context: Context) : RecyclerView.Adapter<SublineupAdapter.ViewHolder>() {
    var itemList = mutableListOf<lineupitem>()
    private var listener : OnItemClickListener? = null
    inner class ViewHolder(private val binding: SublineupItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(item: lineupitem) {
            val name = item.name
            val num = item.num
            val position = item.postion
            binding.playerNum.text=num.toString()
            binding.playerName.text=name
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
        return ViewHolder(SublineupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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
