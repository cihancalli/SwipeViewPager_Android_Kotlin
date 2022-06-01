package com.diten.tech.swipeviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import com.diten.tech.swipeviewpager.adapter.MyAdapter
import com.diten.tech.swipeviewpager.model.MyModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //actionbar
    private lateinit var actionBar: ActionBar

    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

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
                val title = myModelList[position].title
                actionBar.title = title
            }

            override fun onPageSelected(position: Int) {
            }



        })
    }

    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        //add items/data to list
        myModelList.add(MyModel(
            "Android Marshmallow",
        "Description," ,
            "October 5, 2015",
            R.drawable.android_c))

        myModelList.add(MyModel(
            "Android Nougat",
            "Description," ,
            "October 22, 2016",
            R.drawable.android_d))

        myModelList.add(MyModel(
            "Android Oreo",
            "Description," ,
            "October 5, 2017",
            R.drawable.android_f))

        myModelList.add(MyModel(
            "Android Pie",
            "Description," ,
            "October 5, 2018",
            R.drawable.android_g))

        myModelList.add(MyModel(
            "Android Q",
            "Description," ,
            "October 5, 2019",
            R.drawable.android_h))

        myAdapter = MyAdapter(this,myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter
        //set default padding
        viewPager.setPadding(100,0,100,0)

    }
}