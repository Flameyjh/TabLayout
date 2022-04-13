package com.yjh.tablayout

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
* 帮助viewpager绑定多个fragment
* */
class MyFragmentPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, fragments: List<Fragment>) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    val fragmentList = fragments

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}