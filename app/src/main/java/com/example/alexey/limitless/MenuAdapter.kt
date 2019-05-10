package com.example.alexey.limitless

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.menu_item.view.*

class MenuAdapter(val menuFeed: MenuFeed) : RecyclerView.Adapter<ViewHolder>() {

//    val videoTitles = listOf("123")

    override fun getItemCount(): Int {
        return menuFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = menuFeed.videos[position]
        holder.view.tv_item.text = video.name
    }
}

class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
//    val tvMenuItem = view.tv_item!!
}

/*
class MenuAdapter(private val items: MenuFeed, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMenuItem.text = items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvMenuItem = view.tv_item!!
 */