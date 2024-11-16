package com.segundoparcial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.segundoparcial.adapter.TabPageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var tlMenu : TabLayout
    private lateinit var vpFragment : ViewPager2
    private lateinit var adapterFragment : FragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponet()
        initListener()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponet() {
        tlMenu =  findViewById(R.id.tlMenu)
        vpFragment = findViewById(R.id.vpFragment)
        adapterFragment = TabPageAdapter(supportFragmentManager , lifecycle)
        tlMenu.addTab(tlMenu.newTab().setText(getString(R.string.home)))
        tlMenu.addTab(tlMenu.newTab().setText(getString(R.string.registro)))
        tlMenu.addTab(tlMenu.newTab().setText(getString(R.string.lista)))
        vpFragment.adapter = adapterFragment
    }

    private fun initListener(){
        tlMenu.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab != null){
                    vpFragment.currentItem =  tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        } )

        vpFragment.registerOnPageChangeCallback(object :  ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tlMenu.selectTab(tlMenu.getTabAt(position))
            }
        })
    }
}