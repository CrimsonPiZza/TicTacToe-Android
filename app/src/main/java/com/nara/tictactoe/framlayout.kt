package com.nara.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_framlayout.*

class framlayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_framlayout)
    }

    fun changeImg(view: View){
        if (bg1.visibility == 0) bg1.visibility = View.INVISIBLE else bg1.visibility = View.VISIBLE
        if (bg2.visibility == 0) bg2.visibility = View.INVISIBLE else bg2.visibility = View.VISIBLE
    }
}
