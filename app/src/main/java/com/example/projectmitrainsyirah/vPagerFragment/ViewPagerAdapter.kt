package com.example.projectmitrainsyirah.vPagerFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class ViewPagerAdapter(
    list: ArrayList<Fragment>,
    manager: FragmentManager,
    lifecyle: Lifecycle) :
    FragmentStateAdapter(manager, lifecyle) {
    private val fragmentList = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}