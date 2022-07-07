package cn.zx.homework1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.swu.cs.lessonfive.R

class HumanAdapter(val humans: ArrayList<Human>) : RecyclerView.Adapter<HumanAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val desc = itemView.findViewById<TextView>(R.id.description)
        val img =  itemView.findViewById<ImageView>(R.id.avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_human,parent,false)
        val holder = TeacherViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val human = humans[position]
        holder.name.text = human.name
        holder.desc.text = human.description
        holder.img.setImageResource(human.avatar)
    }

    override fun getItemCount(): Int {
        return humans.size
    }
}