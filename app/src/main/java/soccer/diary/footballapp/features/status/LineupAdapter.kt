package soccer.diary.footballapp.features.status

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import soccer.diary.footballapp.R
import soccer.diary.footballapp.databinding.LineupItemBinding
import soccer.diary.footballapp.model.Statistic
import soccer.diary.footballapp.model.lineupitem

class LineupAdapter(private val context: Context) : RecyclerView.Adapter<LineupAdapter.ViewHolder>() {
    var itemList = mutableListOf<lineupitem>()
    private var listener: OnItemClickListener? = null

    inner class ViewHolder(private val binding: LineupItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: lineupitem) {
            val name = item.name
            val num = item.num
            val position = item.postion
            val sub = item.sub
            if (sub == true) {
                binding.sub.text = "sub"
                binding.sub.setTextColor(Color.GRAY)
                binding.playerNum.setTextColor(Color.GRAY)
                binding.playerName.setTextColor(Color.GRAY)
                binding.playerPosition.setTextColor(Color.GRAY)
            } else binding.sub.text = " "
            binding.playerNum.text = num.toString()
            binding.playerName.text = name
            binding.playerPosition.text = position
            itemView.tag = item
        }

        override fun onClick(v: View?) {
            if (position != RecyclerView.NO_POSITION) {
                val player = itemList[position]
                val fragment = PlayerDialog()
                val bundle = Bundle()
                bundle.putString("face", player.face)
                bundle.putString("name", player.name)
                bundle.putParcelableArrayList("statistics", ArrayList(player.statistics))
                fragment.arguments = bundle
                val fragmentManager = (binding.root.context as AppCompatActivity).supportFragmentManager
                fragment.show(fragmentManager, "PlayerDialogTag")
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(data: lineupitem)
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

    fun addItem(item: lineupitem) {
        itemList.add(item)
        notifyItemChanged(itemCount - 1)
    }

    fun removeAllItem() {
        itemList = mutableListOf()
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}
