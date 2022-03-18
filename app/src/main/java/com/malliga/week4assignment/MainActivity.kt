package com.malliga.week4assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.malliga.week4assignment.adapter.TabAdapter
import com.malliga.week4assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var tabTitle = arrayOf("People", "Room")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pager = binding.tabDisplay
        var tl = binding.tabContent
        pager.adapter = TabAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager){
            tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}