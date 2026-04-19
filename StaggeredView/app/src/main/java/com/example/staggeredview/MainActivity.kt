package com.example.staggeredview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.staggeredview.Adapter
import com.example.staggeredview.R

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null

    // Using ArrayList to store images data
    private val images: ArrayList<Int> = arrayListOf(
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8,
        R.drawable.img_9,
        R.drawable.img_10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting reference of recyclerView
        recyclerView = findViewById(R.id.recyclerView)

        // Setting the layout as Staggered Grid for vertical orientation
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView?.layoutManager = staggeredGridLayoutManager

        // Sending reference and data to Adapter
        val adapter = Adapter(this@MainActivity, images)

        // Setting Adapter to RecyclerView
        recyclerView?.adapter = adapter
    }
}