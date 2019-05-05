package com.example.alexey.limitless

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_layout.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        bt_ok.setOnClickListener {
            val myIntent = Intent(this, MenuActivity::class.java)
            startActivity(myIntent)
        }
    }
}
