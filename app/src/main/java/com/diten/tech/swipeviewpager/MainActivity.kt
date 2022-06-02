package com.diten.tech.swipeviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.diten.tech.swipeviewpager.adapter.DayAdapter
import com.diten.tech.swipeviewpager.adapter.MonthAdapter
import com.diten.tech.swipeviewpager.model.DayModel
import com.diten.tech.swipeviewpager.model.MonthModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //actionbar
    private lateinit var actionBar: ActionBar

    private lateinit var myMonthList: ArrayList<MonthModel>
    private lateinit var myDayList: ArrayList<DayModel>
    private lateinit var monthAdapter: MonthAdapter
    private lateinit var dayAdapter: DayAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init actionbar
        actionBar = this.supportActionBar!!

        loadCards()

        //add page change listener
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
               //change title of actionbar
                val title = myMonthList[position].title
                actionBar.title = title
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

    private fun loadCards() {
        //init list
        myMonthList = ArrayList()
        myDayList = ArrayList()

        for (i in 1..30){
            myDayList.add(DayModel(i))
        }

        //add items/data to list
        myMonthList.add(MonthModel(
            "JANUARY",myDayList))

        myMonthList.add(MonthModel(
            "FEBRUARY",myDayList))

        myMonthList.add(MonthModel(
            "MARCH",myDayList))

        myMonthList.add(MonthModel(
            "APRIL",myDayList))

        myMonthList.add(MonthModel(
            "MAY",myDayList))

        myMonthList.add(MonthModel(
            "JUNE",myDayList))

        myMonthList.add(MonthModel(
            "JULY",myDayList))

        myMonthList.add(MonthModel(
            "AUGUST",myDayList))

        myMonthList.add(MonthModel(
            "SEPTEMBER",myDayList))

        myMonthList.add(MonthModel(
            "OCTOBER",myDayList))

        myMonthList.add(MonthModel(
            "NOVEMBER",myDayList))

        myMonthList.add(MonthModel(
            "DECEMBER",myDayList))



        monthAdapter = MonthAdapter(this,myMonthList)

        //set adapter to viewpager
        viewPager.adapter = monthAdapter
        viewPager.offscreenPageLimit = 12
        //set default padding
        viewPager.setPadding(10,0,10,0)

        /*
        recyclerView = findViewById(R.id.rv_day)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,7)
        dayAdapter = DayAdapter(applicationContext)
        recyclerView.adapter = dayAdapter

        dayAdapter.setDataList(myDayList)

         */

    }
}