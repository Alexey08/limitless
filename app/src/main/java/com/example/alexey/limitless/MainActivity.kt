package com.example.alexey.limitless

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.alexey.limitless.menuList.MenuActivity
import com.example.alexey.limitless.model.StartFeed
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.main_layout.*
import okhttp3.*
import java.io.IOException


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        bt_ok.setOnClickListener {
            val myIntent = Intent(this, MenuActivity::class.java)
            startActivity(myIntent)
        }

        mJson1()
    }

    private fun mJson1() {

        val url = "https://api.vk.com/method/groups.getById?group_id=182089910&fields=description&access_token=933765929337659293376592b9935d3b639933793376592cfe0a87dc9dbbcb8e017199f&v=5.95"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {

                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                println(gson)

                val startFeed = gson.fromJson(body, StartFeed::class.java)

                runOnUiThread {
                    tv_start.text = startFeed.response[0].description
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Error! Failed to execute request!")
            }
        })
    }
}
