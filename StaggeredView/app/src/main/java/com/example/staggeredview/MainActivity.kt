package com.example.staggeredview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val images = listOf(
        R.drawable.image_01,
        R.drawable.image_02,
        R.drawable.image_03,
        R.drawable.image_04,
        R.drawable.image_05,
        R.drawable.image_06,
        R.drawable.image_07,
        R.drawable.image_08,
        R.drawable.image_09,
        R.drawable.image_10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = Adapter(images)
    }
}