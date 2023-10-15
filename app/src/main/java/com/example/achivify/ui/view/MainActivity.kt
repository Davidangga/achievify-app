package com.example.achivify.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.achivify.R
import com.example.achivify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout,binding.toolbar,R.string.open_drawer, R.string.close_drawer)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val backButton = binding.navigationView.getHeaderView(0).findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener{
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }

    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }
}