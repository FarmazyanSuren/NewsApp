package com.sf.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sf.newsapp.ext.ActivityExtensions.addFragment

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addFragment(MainFragment.newInstance())
        }
    }
}