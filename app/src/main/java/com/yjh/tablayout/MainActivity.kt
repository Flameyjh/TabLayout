package com.yjh.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/*
* TabLayout提供了一个水平布局用于展示tabs
* 与ViewPager2结合使用实现页面和标签联动的效果
* */

class MainActivity : AppCompatActivity(){

    lateinit var viewpager: ViewPager2
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPager()
    }

    private fun initPager() {

        viewpager = findViewById(R.id.id_viewpager)
        val fragments = ArrayList<Fragment>()
        fragments.add(BlankFragment.newInstance("第1页"))
        fragments.add(BlankFragment.newInstance("第2页"))
        fragments.add(BlankFragment.newInstance("第3页"))
        fragments.add(BlankFragment.newInstance("第4页"))
        fragments.add(BlankFragment.newInstance("第5页"))
        fragments.add(BlankFragment.newInstance("第6页"))
        fragments.add(BlankFragment.newInstance("第7页"))
        viewpager.adapter = MyFragmentPagerAdapter(supportFragmentManager, lifecycle, fragments)

        tabLayout = findViewById(R.id.tablayout)

        //另一种方法：直接绑定tabLayout和viewpager2。但是tab.text不能自定义
//        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
//            tab.text = "OBJECT ${(position + 1)}"
//        }.attach()

        //点击上部tab，页面改变
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewpager.setCurrentItem(it.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        //viewPager2提供给外部的监听
        viewpager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }
            //随着页面滑动，上部tab改变
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.setScrollPosition(position, 0f, true);
            }
        })
    }

}