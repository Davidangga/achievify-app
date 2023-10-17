package com.example.achivify.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.achivify.R
import com.example.achivify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialise binding mechanism
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // change action bar into toolbar and make hamburger icon
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout,binding.toolbar,R.string.open_drawer, R.string.close_drawer)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // listener for back button when drawer activate
        val backButton = binding.navigationView.getHeaderView(0).findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener{
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }

        binding.navigationView.setNavigationItemSelectedListener {
            item: MenuItem ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_todo -> fragment = TodoListFragment()
                R.id.nav_achievement -> fragment = AchievementsFragment()
                R.id.nav_explore -> fragment = ExploreFragment()
                else -> fragment = TodoListFragment()
            }
            if(fragment != null){
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fragment_container, fragment)
                ft.commit()
                binding.drawerLayout.closeDrawers()
                true
            }
            else{
                false
            }

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