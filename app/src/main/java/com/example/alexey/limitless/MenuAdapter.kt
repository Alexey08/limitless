@file:Suppress("DEPRECATION")

package com.example.alexey.limitless

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alexey.limitless.model.Itms
import com.example.alexey.limitless.model.MenuFeed
import com.example.alexey.limitless.model.Szs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.menu_item.view.*

@Suppress("DEPRECATION")
class MenuAdapter(private val menuFeed: MenuFeed) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return menuFeed.response.items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = menuFeed.response.items[position]
        holder.view.tv_item.text = "${item.text.substring(0..50)} \n\n ... Читать далее!"

        val dt = item.date
        val sdf = java.text.SimpleDateFormat("HH:mm'  'dd-MM-yyyy")
        val date = java.util.Date(dt*1000)
        holder.view.tv_data.text = sdf.format(date)

        val imageView = holder.view.iv_item
        Picasso.with(holder.view.context).load(menuFeed.response.items[position].attachments[0].photo.sizes[6].url).into(imageView)

        holder.txt = item
        holder.img = menuFeed.response.items[position].attachments[0].photo.sizes[6]


    }
}

class ViewHolder (val view: View, var txt: Itms? = null, var img: Szs? = null) : RecyclerView.ViewHolder(view){

    companion object {
        var postText = "Post Text"
        var postImage = "Post Image"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, PostActivity::class.java)

            intent.putExtra(postText, txt?.text)
            intent.putExtra(postImage, img?.url)

            view.context.startActivity(intent)
        }
    }
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
}

 */