package com.segundoparcial

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.NombreAdapter
import com.example.myapplication.helpers.DataBaseHelper
import com.google.android.material.navigation.NavigationView
import com.segundoparcial.view.HomeFragment
import com.segundoparcial.view.ListFragment
import com.segundoparcial.view.RegisterFragment

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout : DrawerLayout
    lateinit var navView : NavigationView
    private  var nameList : MutableList<String> = mutableListOf()
    private lateinit var dataBaseHelper: DataBaseHelper
    private lateinit var adapter : NombreAdapter
    private lateinit var etName : EditText
    private lateinit var btnLoad : ImageButton
    private lateinit var btnSave : Button
    private lateinit var rvNameList: RecyclerView
    private var imageUri : Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initUi(savedInstanceState)
        initComponet()
        initListener()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initComponet() {
        drawerLayout =  findViewById(R.id.main)
        navView = findViewById(R.id.navView)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open ,R.string.close)
    }

    private fun initListener(){
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fgContainer, HomeFragment())
                    .addToBackStack(null)
                    .commit()

                R.id.nav_Register -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fgContainer, RegisterFragment())
                    .addToBackStack(null)
                    .commit()

                R.id.nav_lista ->supportFragmentManager.beginTransaction()
                    .replace(R.id.fgContainer, ListFragment())
                    .addToBackStack(null)
                    .commit()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true


        }

    }

    private  fun initUi(savedInstanceState : Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fgContainer, HomeFragment())
                .addToBackStack(null)
                .commit()
        }
    }


    fun actualizarList () {
        val data = dataBaseHelper.selectAllName()
        nameList.clear()
        nameList.addAll(data)
        adapter.notifyDataSetChanged()
        rvNameList.scrollToPosition(nameList.count() - 1)
    }

    fun initUi(){
        actualizarList()
    }

}