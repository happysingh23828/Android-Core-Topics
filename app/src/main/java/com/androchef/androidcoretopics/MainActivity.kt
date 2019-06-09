package com.androchef.androidcoretopics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androchef.androidcoretopics.resources.AnimationDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClicks()
    }

    private fun onClicks() {
        btnAnimation.setOnClickListener {
            AnimationDemoActivity.start(this)
        }
    }
}
