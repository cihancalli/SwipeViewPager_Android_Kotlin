package com.diten.tech.swipeviewpager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.diten.tech.swipeviewpager.R
import com.diten.tech.swipeviewpager.model.MonthModel
import kotlinx.android.synthetic.main.card_item.view.*

class MonthAdapter (private val context: Context, private val myModelArryList:ArrayList<MonthModel>) :
    PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return myModelArryList.size //return list of records/items
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflate layout card_item.xml

        val view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false)

        //get data
        val model = myModelArryList[position]
        val childRecyclerView  = view.childRecyclerView

        childRecyclerView.apply {
            layoutManager = GridLayoutManager(context,7)
            val dayAdapter = DayAdapter(context)
            childRecyclerView.adapter = dayAdapter
            dayAdapter.setDataList(model.dayList)
        }
        //val title = model.title

        //set data to ui views
        /*
        view.bannerIv.setImageResource(image)
        view.titleTv.text = title
        view.descriptionTv.text = description
        view.dateTv.text = date
        */

        //handle item/card click

        /*
        view.setOnClickListener {
            Toast.makeText(context,"$title",Toast.LENGTH_SHORT).show()
        }

         */

        //add view to container
        container.addView(view,position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}