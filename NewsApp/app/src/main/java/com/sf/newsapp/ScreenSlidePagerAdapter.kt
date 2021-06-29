package com.sf.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(
    act: FragmentActivity, private val pageCount: Int = 2
) : FragmentStateAdapter(act) {

    override fun getItemCount() = pageCount

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewsFragment.newInstance()
            else -> FavoriteFragment.newInstance()
        }
    }

}
