package com.sf.newsapp.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sf.newsapp.R

//object created for more safety , in my practice too many cases when compiler can't find ext function , but this solved for me
object ActivityExtensions {

    fun FragmentActivity.addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .commit()
    }
}