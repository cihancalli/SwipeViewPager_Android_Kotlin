package com.diten.tech.swipeviewpager.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.diten.tech.swipeviewpager.R
import com.diten.tech.swipeviewpager.model.DayModel

class DayAdapter (private var context: Context) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    var dataList = emptyList<DayModel>()

    internal fun setDataList(datalist : List<DayModel>){
        this.dataList = datalist
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title : TextView

        init {
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cell_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: DayAdapter.ViewHolder, position: Int) {
        var data = dataList[position]

        holder.title.text  = data.CurrentDay.toString()

            holder.title.setTextColor(Color.parseColor("#AEAEAE"))


        holder.itemView.setOnClickListener {
            Toast.makeText(context,"${data.CurrentDay}", Toast.LENGTH_SHORT).show()
        }

    }


}