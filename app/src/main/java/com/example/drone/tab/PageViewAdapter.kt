package com.example.drone.tab

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PageViewAdapter(fm: FragmentManager, val myTabs:ArrayList<BaseTabFargment>):FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int) = myTabs[position]
    override fun getCount() = myTabs.size
}