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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    //actionbar
    private lateinit var actionBar: ActionBar

    private lateinit var myMonthList: ArrayList<MonthModel>

    private lateinit var myDayList1: ArrayList<DayModel>
    private lateinit var myDayList2: ArrayList<DayModel>
    private lateinit var myDayList3: ArrayList<DayModel>
    private lateinit var myDayList4: ArrayList<DayModel>
    private lateinit var myDayList5: ArrayList<DayModel>
    private lateinit var myDayList6: ArrayList<DayModel>
    private lateinit var myDayList7: ArrayList<DayModel>
    private lateinit var myDayList8: ArrayList<DayModel>
    private lateinit var myDayList9: ArrayList<DayModel>
    private lateinit var myDayList10: ArrayList<DayModel>
    private lateinit var myDayList11: ArrayList<DayModel>
    private lateinit var myDayList12: ArrayList<DayModel>

    private lateinit var monthAdapter: MonthAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init actionbar
        actionBar = this.supportActionBar!!

        loadCards()
        date()

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
                val title = myMonthList[1].title
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())
                actionBar.title = "$title 2022"
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

    fun date(){

        val dayf = SimpleDateFormat("dd")
        val montf = SimpleDateFormat("M")
        val yearf = SimpleDateFormat("yyyy")

        val t = arrayListOf(0,3,2,5,0,3,5,1,4,6,2,4)
        val y = yearf.format(Date()).toInt()
        val m = montf.format(Date()).toInt()
        val d = dayf.format(Date()).toInt()
        val sum =(y + y/4 - y/100 + y/400 +t[m-1] + d) % 7

        println("Gün : ${sum} $d/$m/$y ")
    }

    private fun loadCards() {
        //init list
        myMonthList = ArrayList()

        myDayList1 = ArrayList()
        myDayList2 = ArrayList()
        myDayList3 = ArrayList()
        myDayList4 = ArrayList()
        myDayList5 = ArrayList()
        myDayList6 = ArrayList()
        myDayList7 = ArrayList()
        myDayList8 = ArrayList()
        myDayList9 = ArrayList()
        myDayList10 = ArrayList()
        myDayList11 = ArrayList()
        myDayList12 = ArrayList()


        //+4 veya +11 Gün Sonraki listeden (35 veya 42)
        val tg = 42

        val a_1 = 31 //Gün sayısı
        val k_1 = 5 // Kayma Sayısı
        val g_1 = a_1 +k_1 //Toplam ileri Gün Sayısı
        var ak_1 = k_1 -1
        for (i in 1..tg){

            val f_1 = i-k_1 // eksik gün sayısı

            if (f_1 >0 && i<=g_1){
                myDayList1.add(DayModel(f_1))
            }
            else if(f_1<=0){
                myDayList1.add(DayModel(31-ak_1))
                ak_1 -=1
            }
            else{
                myDayList1.add(DayModel(i-g_1))
            }

        }

        var a_2 = 28
        if (2022 % 4 == 0){
            a_2 = 29
        }
        val k_2 = g_1 % 7 // 3 Gün kayma
        val g_2 = a_2 + k_2
        var ak_2 = k_2 -1
        for (i in 1..tg){

            val f_2 = i - k_2

            //Mevcut ayın günleri
            if (f_2>0 && i<=g_2){
                myDayList2.add(DayModel(f_2))
            }
            //Geçmiş Ayın Günleri
            else if(f_2<=0){
                myDayList2.add(DayModel(a_1-ak_2))
                ak_2 -=1

            }
            //İleri ayın Günleri
            else{
                myDayList2.add(DayModel(i-g_2))
            }
        }

        val a_3 = 31
        val k_3 = g_2 % 7 //3 gün kayma
        val g_3 = a_3 + k_3
        var ak_3 = k_3 -1
        for (i in 1..tg){

            val f_3 = i - k_3

            if (f_3>0 && i<=g_3){
                myDayList3.add(DayModel(f_3))
            }
            else if(f_3<=0){
                myDayList3.add(DayModel(a_2-ak_3))
                ak_3 -=1
            }
            else{
                myDayList3.add(DayModel(i-g_3))
            }
        }

        val a_4 = 30
        val k_4 = g_3 % 7
        val g_4 = a_4 + k_4
        var ak_4 = k_4 -1
        for (i in 1..tg){

            val f_4 = i - k_4

            if (f_4>0 && i<=g_4){
                myDayList4.add(DayModel(f_4))
            }
            else if(f_4<=0){
                myDayList4.add(DayModel(a_3-ak_4))
                ak_4 -=1
            }
            else{
                myDayList4.add(DayModel(i-g_4))
            }
        }

        val a_5 = 31
        val k_5 = g_4 % 7
        val g_5 = a_5 + k_5
        var ak_5 = k_5 -1
        for (i in 1..tg){

            val f_5 = i - k_5

            if (f_5>0 && i<=g_5){
                myDayList5.add(DayModel(f_5))
            }
            else if(f_5<=0){
                myDayList5.add(DayModel(a_4-ak_5))
                ak_5 -=1
            }
            else{
                myDayList5.add(DayModel(i-g_5))
            }
        }

        val a_6 = 30
        val k_6 = g_5 % 7
        val g_6 = a_6 + k_6
        var ak_6 = k_6 -1
        for (i in 1..tg){

            val f_6 = i - k_6

            if (f_6>0 && i<=g_6){
                myDayList6.add(DayModel(f_6))
            }
            else if(f_6<=0){
                myDayList6.add(DayModel(a_5-ak_6))
                ak_6 -=1
            }
            else{
                myDayList6.add(DayModel(i-g_6))
            }
        }
        val a_7 = 31
        val k_7 = g_6 % 7
        val g_7 = a_7 + k_7
        var ak_7 = k_7 -1
        for (i in 1..tg){

            val f_7 = i - k_7

            if (f_7>0 && i<=g_7){
                myDayList7.add(DayModel(f_7))
            }
            else if(f_7<=0){
                myDayList7.add(DayModel(a_6-ak_7))
                ak_7 -=1
            }
            else{
                myDayList7.add(DayModel(i-g_7))
            }
        }
        val a_8 = 31
        val k_8 = g_7 % 7
        val g_8 = a_8 + k_8
        var ak_8 = k_8 -1
        for (i in 1..tg){

            val f_8 = i - k_8

            if (f_8>0 && i<=g_8){
                myDayList8.add(DayModel(f_8))
            }
            else if(f_8<=0){
                myDayList8.add(DayModel(a_7-ak_8))
                ak_8 -=1
            }
            else{
                myDayList8.add(DayModel(i-g_8))
            }
        }

        val a_9 = 30
        val k_9 = g_8 % 7
        val g_9 = a_9 + k_9
        var ak_9 = k_9 -1
        for (i in 1..tg){

            val f_9 = i - k_9

            if (f_9>0 && i<=g_9){
                myDayList9.add(DayModel(f_9))
            }
            else if(f_9<=0){
                myDayList9.add(DayModel(a_8-ak_9))
                ak_9 -=1
            }
            else{
                myDayList9.add(DayModel(i-g_9))
            }
        }

        val a_10 = 31
        val k_10 = g_9 % 7
        val g_10 = a_10 + k_10
        var ak_10 = k_10 -1
        for (i in 1..tg){

            val f_10 = i - k_10

            if (f_10>0 && i<=g_10){
                myDayList10.add(DayModel(f_10))
            }
            else if(f_10<=0){
                myDayList10.add(DayModel(a_9-ak_10))
                ak_10 -=1
            }
            else{
                myDayList10.add(DayModel(i-g_10))
            }
        }

        val a_11 = 30
        val k_11 = g_10 % 7
        val g_11 = a_11 + k_11
        var ak_11 = k_11 -1
        for (i in 1..tg){

            val f_11 = i - k_11

            if (f_11>0 && i<=g_11){
                myDayList11.add(DayModel(f_11))
            }
            else if(f_11<=0){
                myDayList11.add(DayModel(a_10-ak_11))
                ak_11 -=1
            }
            else{
                myDayList11.add(DayModel(i-g_11))
            }
        }

        val a_12 = 31
        val k_12 = g_11 % 7
        val g_12 = a_12 + k_12
        var ak_12 = k_12 -1
        for (i in 1..tg){

            val f_12 = i - k_12

            if (f_12>0 && i<=g_12){
                myDayList12.add(DayModel(f_12))
            }
            else if(f_12<=0){
                myDayList12.add(DayModel(a_11-ak_12))
                ak_12 -=1
            }
            else{
                myDayList12.add(DayModel(i-g_12))
            }
        }



        //add items/data to list
        myMonthList.add(MonthModel(
            "JANUARY",myDayList1))

        myMonthList.add(MonthModel(
            "FEBRUARY",myDayList2))

        myMonthList.add(MonthModel(
            "MARCH",myDayList3))

        myMonthList.add(MonthModel(
            "APRIL",myDayList4))

        myMonthList.add(MonthModel(
            "MAY",myDayList5))

        myMonthList.add(MonthModel(
            "JUNE",myDayList6))

        myMonthList.add(MonthModel(
            "JULY",myDayList7))

        myMonthList.add(MonthModel(
            "AUGUST",myDayList8))

        myMonthList.add(MonthModel(
            "SEPTEMBER",myDayList9))

        myMonthList.add(MonthModel(
            "OCTOBER",myDayList10))

        myMonthList.add(MonthModel(
            "NOVEMBER",myDayList11))

        myMonthList.add(MonthModel(
            "DECEMBER",myDayList12))





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