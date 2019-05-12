package com.example.alexey.limitless

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.menu_item.view.*

class MenuAdapter(val menuFeed: MenuFeed) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return menuFeed.response.items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = menuFeed.response.items[position].text
        holder.view.tv_item.text = text

//        val thumbnailImageView = holder.view.iv_item
//        Picasso.with(holder.view.context).load(video.imageUrl).into(thumbnailImageView)


    }
}

class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)




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
}

 */