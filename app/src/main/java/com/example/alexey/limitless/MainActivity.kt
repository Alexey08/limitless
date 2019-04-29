package com.example.alexey.limitless

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_layout.*


class MainActivity : AppCompatActivity() {

    val menuItem: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        addMenu()

        rv_menu.layoutManager = LinearLayoutManager(this)
        rv_menu.adapter = MenuAdapter(menuItem,this)
    }

    private fun addMenu(){
        menuItem.add("1")
        menuItem.add("2")
        menuItem.add("3")
        menuItem.add("4")
        menuItem.add("5")
        menuItem.add("6")
        menuItem.add("7")
        menuItem.add("8")
        menuItem.add("9")
        menuItem.add("10")
    }

}