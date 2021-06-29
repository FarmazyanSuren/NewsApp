package com.sf.newsapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private var viewPager: ViewPager2? = null
    private val tabList: List<String> = listOf("FEED", "FAVORITE")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act = activity
        if (act == null || act.isFinishing) {
            return
        }

        viewPager = view.findViewById(R.id.viewPager)
        viewPager?.adapter = ScreenSlidePagerAdapter(act)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            viewPager ?: return
        ) { tab, position -> tab.text = tabList[position] }.attach()
    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}